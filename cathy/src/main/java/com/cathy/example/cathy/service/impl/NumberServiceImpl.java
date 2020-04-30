package com.cathy.example.cathy.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cathy.example.cathy.service.NumberService;
@Service
public class NumberServiceImpl implements NumberService {

	
	 private static String mappings[][] = {
		        {"0"}, {"1"}, {"A", "B", "C","2"}, {"D", "E", "F","3"}, {"G", "H", "I","4"},
		        {"J", "K", "L","5"}, {"M", "N", "O","6"}, {"P", "Q", "R", "S","7"}, 
		        {"T", "U", "V","8"}, {"W", "X", "Y", "Z","9"}
		    };

	@Override
	public List<String> possibleNumbers(String number) {
		return generateCombos(number);
	}
	
	private  static List<String> generateCombos(String phoneNumber) {
        // This will hold the final list of combinations
        List<String> combos = new LinkedList<String>();

        // Call the helper method with an empty prefix and the entire 
        // phone number as the remaining part.
        generateAllCompination(combos, "", phoneNumber);

        return combos;
    }
	
	 private static void generateAllCompination(List<String> combos, 
	            String prefix, String remaining) {
	        // The current digit we are working with
	        int digit = Integer.parseInt(remaining.substring(0, 1));

	        if (remaining.length() == 1) {
	            // We have reached the last digit in the phone number, so add 
	            // all possible prefix-digit combinations to the list
	            for (int i = 0; i < mappings[digit].length; i++) {
	                combos.add(prefix + mappings[digit][i]);
	            }
	        } else {
	            // Recursively call this method with each possible new 
	            // prefix and the remaining part of the phone number.
	            for (int i = 0; i < mappings[digit].length; i++) {
	            	generateAllCompination(combos, prefix + mappings[digit][i], 
	                        remaining.substring(1));
	            }
	        }
	    }

}
