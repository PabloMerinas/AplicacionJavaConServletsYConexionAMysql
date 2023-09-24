package model;

public class User {

	private String name;
	private String subName;
	private String dni;
	private String username;
	private String password;

	/**
	 * @param name
	 * @param subName
	 * @param dni
	 * @param username
	 * @param password
	 */
	public User(String name, String subName, String dni, String username, String password) {
		this.name = name;
		this.subName = subName;
		this.dni = dni;
		this.username = username;
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the subName
	 */
	public String getSubName() {
		return subName;
	}

	/**
	 * @param subName the subName to set
	 */
	public void setSubName(String subName) {
		this.subName = subName;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [getName()=" + getName() + ", getSubName()=" + getSubName() + ", getDni()=" + getDni()
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + "]";
	}

}
