package com.ibm.ph.amperca.optionals;

import java.util.Optional;

public class Main {
   public static void main(String[] args) {
    
        // Point of optional is to eliminate null checks

        String myValue = "This is my String";
        myValue = null;
        // wrap in optinal

        // Optional.ofNullable
        // raise NoSuchElementException
        try {
            Optional<String> myValueOptional_isNull = Optional.ofNullable(myValue);
            System.out.println(myValueOptional_isNull.get());
        } catch(Exception ex) {
            System.out.println(ex);
        }
        // Optional.of
        // raise a null pointer
        try {
            Optional<String> myValueOptional_of= Optional.of(myValue);
            System.out.println(myValueOptional_of.get());
        } catch(Exception ex) {
            System.out.println(ex);
        }
        
        // if example of using optional
        // you can do functional programming
        // filters, maps
        // no need of null checks

        String bearerHeader = "Authorization: Bearer my-very-long-long-long-token";
    
        // warper for optinal
        Optional<String> bearerOptional = Optional.ofNullable(bearerHeader);
        String token = "";

        token = bearerOptional.filter(header -> header.contains("Authorization") 
        && header.substring(15, 21).trim().equalsIgnoreCase("bearer"))
        .map(header->header.substring(22))
        .orElseThrow(()-> new RuntimeException("Invalid Token"));
        System.out.println("Using Optional: ");
        System.out.println(token);

        // without using optional
        // with null checks
        if(bearerHeader != null && bearerHeader.contains("Authorization") 
            && bearerHeader.substring(15, 21).equalsIgnoreCase("bearer")) {
                token = bearerHeader.substring(22);
            System.out.println("Using not using optional: ");
            System.out.println(token);
        } else {
            throw new RuntimeException("Invalid token");
        }


   } 
}
