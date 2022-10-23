package com.example.demo;

import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import lombok.Data;

@Entity
@Data
@NamedNativeQuery(name = "OrderDetails.getUserOrderSummary",
 query= 
 	"  select "
	    + "  p.sname as shoeName , p.scost as shoeCost ,"
	    + "  u.uname as userName , u.uemail as userEmail , "
	    + "  o.order_id as orderId "
	    + " from "
	    + " product p ,user u , order_details o "
	    + " where "
	    + "  o.user_id= :userId and o.user_id =  u.uid and "
	    + "  p.sid = o.shoe_id",
	    
resultSetMapping = "Mapping.UserOrderSummary"		
)
@SqlResultSetMapping(name = "Mapping.UserOrderSummary",
  classes = @ConstructorResult (
		    targetClass = UserOrderSummary.class,
		    columns = {
		    	@ColumnResult(name= "orderId"),
		    	@ColumnResult(name= "userName"),
		    	@ColumnResult(name= "shoeName"),
		    	@ColumnResult(name= "shoeCost"),
		    	@ColumnResult(name= "userEmail"),
		    	
		    })
)
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private int userId;
	private int shoeId;
}
