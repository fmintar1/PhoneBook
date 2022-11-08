package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<String, List<String>>());
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, new ArrayList<String>());
        phonebook.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, new ArrayList<String>(List.of(phoneNumbers)));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.containsKey(name) && phonebook.get(name).contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String result = "";
        for( String key : phonebook.keySet()) {
            if(phonebook.get(key).contains(phoneNumber)) {
                result = key;
            }
        }
        return result;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
