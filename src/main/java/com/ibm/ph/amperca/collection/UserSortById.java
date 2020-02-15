package com.ibm.ph.amperca.collection;

import java.util.Comparator;

public class UserSortById implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		if (o1.getId() == o2.getId()) return 0;
		else if(o1.getId() > o2.getId()) return 1;
		return -1;
	}

}
