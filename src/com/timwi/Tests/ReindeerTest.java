package com.timwi.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.timwi.Winner;

class ReindeerTest {

	@Test
	void test() {
		String result = null;
		//Variable declaration		
		String fileName = "src/com/timwi/resources/reindeer-olympics.txt";
		Winner w = new Winner("", 0, 0, 0);

		try (BufferedReader input = Files.newBufferedReader(Paths.get(fileName))) {
			 result = w.winner(input);

		} catch (IOException e) {
			e.printStackTrace();
		}				
        					
        		
        //Assert statements		
        assertEquals(result,"The winning reindeer traveled 2660km");					
        					
        assertNotNull(result);			
        			
	}

}
