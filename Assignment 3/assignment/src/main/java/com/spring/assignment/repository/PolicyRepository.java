package com.spring.assignment.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.assignment.model.Policy;
@Repository
public class PolicyRepository {
	
	@Autowired
	private JdbcTemplate jdbc; 
	

	public List<Policy> findAllpolicies() {
		 // SQL query to get all active policies
        String sql = "SELECT * from policy";
        
        // Prepare the statement with the is_active flag as true
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql);
                return pstmt;
            }
        };

        // RowMapper to map result set to Policy object
        RowMapper<Policy> rowMapper = new RowMapper<Policy>() {
            @Override
            public Policy mapRow(ResultSet rs, int rowNum) throws SQLException {
                Policy policy = new Policy();
                policy.setId(rs.getInt("id"));        // Set policy id
                policy.setAmount(rs.getInt("amount"));  // Set policy amount
                policy.setIs_active(rs.getBoolean("is_active"));
                return policy;
            }
        };

        return jdbc.query(psc, rowMapper);
	}


	public void enterpolicies(int id, int amount) {
		String sql="insert into policy values(?,?,?)";
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override 
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				 PreparedStatement pstmt =   con.prepareStatement(sql);
				 pstmt.setInt(1, id);
				 pstmt.setInt(2, amount);
				 pstmt.setBoolean(3, true);
				 
				return pstmt;
			}
			
		};
		jdbc.update(psc);
		
	}


	public void deletepolicy(int id) {
		String sql="update policy set is_active=false where id=?";
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt =  con.prepareStatement(sql);
				pstmt.setInt(1, id);
				return pstmt;
			}
			
		};
		jdbc.update(psc);
		
	}

}
