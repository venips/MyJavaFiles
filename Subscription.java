package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="subscription")

public class Subscription {
	@Id
	@Column(name="sub_id")
	private int subscriptionId;
	
	@Column(name="sub_name")
	private String subscriptionName;
	
	@Column(name="sub_type")
	private String subscriptionType;
	
	@ManyToMany
	@JoinTable(name="CustomerSubscriptionLink",
	joinColumns = {@JoinColumn(name="sid")},
	inverseJoinColumns = {@JoinColumn(name="cid")})
	Set<Customer> customers = new HashSet<Customer>();

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

}
