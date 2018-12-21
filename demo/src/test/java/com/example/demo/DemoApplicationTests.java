package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class DemoApplicationTests {

	public static class User{
		public String name;
		public Address address;
		@Override
		public String toString() {
			return "User [name=" + name + ", address=" + address + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}


		public User(String name, Address address) {
			super();
			this.name = name;
			this.address = address;
		}
		public User(String name) {
			super();
			this.name = name;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		public User() {
			super();
		}
	}


	public static class  Address
	{			public String getZipcode() {
		return zipcode;
	}
	@Override
	public String toString() {
		return "Address [zipcode=" + zipcode + ", street=" + street + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}


	public String zipcode;
	public String street;
	public Address() {
		super();
	}

	public Address(String zipcode, String street) {

		this.zipcode = zipcode;
		this.street = street;
	}
	}


	@Test
	public void javaToJsonTest() {
		Address ad = new Address("75000","rue jean jaures");
		User us = new User("toto",ad);
		String actual = DemoApplication.javaToJson(us);

		String json =  "{\"name\":\"toto\",\"address\":{\"zipcode\":\"75000\",\"street\":\"rue jean jaures\"}}";

		assertEquals(json, actual);
	}

	@Test
	public void jsonToJavaTest() {
		Address ad = new Address("75000","rue jean jaures");
		User us = new User("toto");
		us.setAddress(ad);
		String json =  "{\"name\":\"toto\",\"address\":{\"zipcode\":\"75000\",\"street\":\"rue jean jaures\"}}";
		User actual = DemoApplication.fromJsonToJava(json, User.class);
		//		System.out.println(actual);
		//		System.out.println(json);
		assertEquals(us, actual);
	}

	@Test
	public void jsonToJavaFieldTest() {
		Address ad = new Address("75000","rue jean jaures");
		User us = new User("toto");
		us.setAddress(ad);
		String json =  "{\"name\":\"toto\",\"address\":{\"zipcode\":\"75000\",\"street\":\"rue jean jaures\"}}";
		User actual = DemoApplication.fromJsonToJava(json, User.class);
		assertEquals(us.getName(), actual.getName());
	}
}

