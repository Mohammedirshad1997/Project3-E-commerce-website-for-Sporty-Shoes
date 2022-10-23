/**
 * 
 */
package com.example.demo;

/**
 * @author Bhakti
 *
 */
public class UserOrderSummary {

	public UserOrderSummary() {}

	public UserOrderSummary(Integer orderId, String userName, String shoeName, 
			String shoeCost , String  userEmail) {
		this.orderId = orderId;
		this.userName = userName;
		this.shoeName = shoeName;
		this.shoeCost = shoeCost;
		this.userEmail = userEmail ;
	}

	private Integer orderId;
	private String userName;
	private String shoeName;
	private String shoeCost;
	private String userEmail ;
	
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShoeName() {
		return shoeName;
	}

	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}

	public String getShoeCost() {
		return shoeCost;
	}

	public void setShoeCost(String shoeCost) {
		this.shoeCost = shoeCost;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "UserOrderSummary [orderId=" + orderId + ", userName=" + userName + ", shoeName=" + shoeName
				+ ", shoeCost=" + shoeCost + ", userEmail=" + userEmail + "]";
	}

	
}
