package com.ibm.ph.amperca.datetime;

import static java.time.Month.MARCH;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
public class Main {
	public static void main(String[] args) {
		
		LocalDate now = LocalDate.now();
		LocalDate bdate = LocalDate.of(2020, 11, 4);
		Long dayUntilBday = now.until(bdate, DAYS);
		LocalDate nowPlus1 = now.plusMonths(1);
		
		// ISO format by default
		System.out.println("=====================================");
		System.out.println("Date " + now);
		System.out.println("Birthday " + bdate);
		System.out.println("Day of the week : " + bdate.getDayOfWeek());
		
		System.out.println("Days until birthday " + dayUntilBday);
		
		
		System.out.println("Now + 1 month" + nowPlus1);
		
		
		LocalTime timeNow = LocalTime.now();
		LocalTime truncatedToMinutes = timeNow.truncatedTo(MINUTES);
		System.out.println("=====================================");
		System.out.println("Time now : " + timeNow);
		
		System.out.println("Time now truncate minutes " + truncatedToMinutes);
		
		System.out.println("Time now plus 1 hr and 25 mins + " + timeNow.plusHours(1).plusMinutes(15));
		
		System.out.println(" >>> " + timeNow.until(LocalTime.of(23,00), HOURS));
		
		System.out.println("Get hour now " + timeNow.getHour());
		
		System.out.println("=====================================");
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		LocalDateTime meeting = LocalDateTime.of(2020, MARCH, 12, 4, 12);
		
		System.out.println("MEETING " + meeting);
		
		LocalDate courseDate = LocalDate.of(2020, 3, 15);
		LocalTime courseTime = LocalTime.of(9, 00);
		
		LocalDateTime courseStart = LocalDateTime.of(courseDate, courseTime);
		
		
		LocalDateTime courseEnd = courseStart.plusDays(3).plusHours(1);
		
		long totalHours = (courseEnd.getHour() - courseStart.getHour()) * (courseStart.until(courseEnd, DAYS) + 1);
		
		System.out.println("courseStart " + courseStart);
		System.out.println("courseEnd " + courseEnd);
		
		System.out.println("Total Hours : " + totalHours);
		
		System.out.println("=====================================");
		
		ZoneId usEastern = ZoneId.of("America/New_York");
		
		LocalDateTime today = LocalDateTime.now();
		
		ZonedDateTime newYork = Instant.now().atZone(usEastern);
		
		ZoneId usEastern1 = ZoneId.of("America/New_York");
		ZonedDateTime newYorkTime = ZonedDateTime.of(today, usEastern1);
		
		System.out.println("Time today (PHL)" + today);
		System.out.println("Time in NY : " + newYork);
		System.out.println("Time in NY : " + newYorkTime.toOffsetDateTime().atZoneSameInstant(usEastern1));
		
		System.out.println("=====================================");
		
		ZoneId honkongZoneId = ZoneId.of("Asia/Hong_Kong");
		ZoneId sydneyZoneId = ZoneId.of("Australia/Sydney");
		
		LocalDateTime meetingM = LocalDateTime.of(2020, 2, 10, 19, 00);
		ZonedDateTime honkongZoneIime = ZonedDateTime.of(meetingM, honkongZoneId);
		ZonedDateTime sydneyZoneTime = ZonedDateTime.of(meetingM, sydneyZoneId);
		
		System.out.println("Asia/Hong kong : " + honkongZoneIime.toOffsetDateTime());
		System.out.println("Austrial/Sydney : " + sydneyZoneTime.toOffsetDateTime());
		
		
	}
}
