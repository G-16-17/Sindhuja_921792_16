package com.finalcheck.observerpattern;

public class TeamMember2 implements INotificationObserver {

	@Override
	public void onBooking() {
		System.out.println("Member 2 received message");
	}

}
