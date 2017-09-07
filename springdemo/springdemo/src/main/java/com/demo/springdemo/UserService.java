package com.demo.springdemo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {

	private int userID;
	private String userName;
	private List<String> hobbies;
	private Map<String, Integer> scores;
	private Set<String> settings;
	private Properties props;

	@Autowired
	private UserDao userDao;

	public Set<String> getSettings() {
		return settings;
	}

	public void setSettings(Set<String> settings) {
		this.settings = settings;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public UserService() {
	}

	public UserService(int userID, String userName, List<String> hobbies, Map<String, Integer> scores,
			UserDao userDao) {
		this.userID = userID;
		this.userName = userName;
		this.hobbies = hobbies;
		this.scores = scores;
		this.userDao = userDao;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public Map<String, Integer> getScores() {
		return scores;
	}

	public void setScores(Map<String, Integer> scores) {
		this.scores = scores;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void PrintInof() {

		System.out.println("UserID:   " + this.getUserID());
		System.out.println("UserName: " + this.getUserName());

		if (this.getHobbies() != null) {
			System.out.println("Hobbies:  " + String.join(",", this.getHobbies()));
		}

		if (this.getScores() != null) {
			String scores = "";

			for (Entry<String, Integer> entry : this.getScores().entrySet()) {
				scores += entry.getKey() + entry.getValue() + "分，";
			}

			System.out.println("Scores:   " + scores);
		}

		if (this.getSettings() != null) {

			String settings = "";
			for (String item : this.getSettings()) {
				settings += item + ",";
			}

			System.out.println("Settings:   " + settings);
		}

		if (this.getProps() != null) {

			String prpos = "";
			for (Entry<Object, Object> item : this.getProps().entrySet()) {
				prpos += item.getKey().toString() + ":" + item.getValue().toString() + "; ";
			}

			System.out.println("Props:   " + prpos);
		}
	}
}
