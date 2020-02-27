package com.ibm.ph.amperca.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Main {
	
	public static void main(String[] args) {
		
		List<User> listUser = new ArrayList<>();
		listUser.add(new User(1, "Charles"));
		listUser.add(new User(3, "Will"));
		listUser.add(new User(2, "James"));
		listUser.add(new User(5, "Devon"));
		listUser.add(new User(4, "Bailey"));
		
		// ArrayList
		// not sorted
		// duplicate
		listUser.add(new User(2, "James"));
		//listUser.add(null);
 		
		
		//listUser.sort(new UserSortById());
		listUser.sort(new UserSortByName());
		for(User user : listUser) {
			System.out.println(user.toString());
		}
		
		System.out.println("-------- Stream ---------");
		
		Predicate<User> pUser = t-> t.getId() == 1;
		
		listUser.stream().filter(pUser).forEach(t->System.out.println("----> " + t.getName()));
		
		// Set
		// sorted
		// does not allow duplicate
		Set<User> setUsers = new TreeSet<>(new UserSortByName());
		setUsers.add(new User(1, "Charles"));
		setUsers.add(new User(2, "Ambre"));
		setUsers.add(new User(4, "Bailey"));
		setUsers.add(new User(3, "Lawrence"));
		
		
		
		for(User user : setUsers) {
			System.out.println(user.toString());
		}
		
		// Map
		// Assosiative Arrays
		// HashMap not syncornize accepts null
		// HashTable syncronize
		Map<Integer, String> map = new TreeMap<>();
		map.put(1, "Charles");
		map.put(2, "Joy");
		map.put(3, "Will");
		
		map.put(2, "Mary Joy");
		
		for(Integer key : map.keySet()) {
			System.out.println("key " + key + " -> value " + map.get(key));
		}
		
		
		map.keySet().stream().forEach(m -> System.out.println("key" + m));
		map.values().stream().forEach(m -> System.out.println("value" + m));
	}

}
