package com.timwi;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Winner extends Reindeer {

	public Winner(String name, int speed, int runTime, int restTime) {
		super(name, speed, runTime, restTime);
		// TODO Auto-generated constructor stub
	}

	private static final Pattern RSPEED_PATTERN = Pattern
			.compile("([A-Za-z]+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds\\.");

	protected static final int TIME = 2503;

	/**
	 * Parse the lines into Reindeer.
	 */
	protected static Stream<Reindeer> parseReindeer(Stream<String> lines) {
		return lines.map(RSPEED_PATTERN::matcher).filter(Matcher::matches).map(m -> new Reindeer(m.group(1),
				Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4))));
	}
	/**
	 * load the input file.
	 */
	public String loadFile(String fileName) {

		String output = null;
		try (BufferedReader FileInput = Files.newBufferedReader(Paths.get(fileName))) {
			output = winner(FileInput);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;

	}
	/**
	 * calculate the winner distance.
	 */
	public String winner(BufferedReader input) {

		int mostTraveled = parseReindeer(input.lines()).mapToInt(r -> r.distanceForTime(TIME)).max().orElse(-1);

		return "The winning reindeer traveled " + mostTraveled + "km";
	}

	public static void main(String[] args) {

		String fileName = "src/com/timwi/resources/reindeer-olympics.txt";

		Winner w = new Winner("", 0, 0, 0);
		
		System.out.print(w.loadFile(fileName));

	}

}