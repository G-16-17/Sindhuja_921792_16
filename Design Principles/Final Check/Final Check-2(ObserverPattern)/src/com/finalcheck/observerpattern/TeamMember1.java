package com.finalcheck.observerpattern;

public class TeamMember1 implements INotificationObserver {

	@Override
	public void onBooking() {
		System.out.println("Member 1 received message");
	}

}
