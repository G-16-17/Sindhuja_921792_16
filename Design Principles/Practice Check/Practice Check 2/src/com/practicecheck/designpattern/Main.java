package com.practicecheck.designpattern;

public class Main {
	
	public static void main(String[] args) {
		INotificationObserver observer1=new SteveObserver();
		INotificationObserver observer2=new JohnObserver();
		INotificationService service=new NotificationService();
		service.addSubscriber(observer1);
		service.addSubscriber(observer2);
		service.notifySubscriber();
		service.removeSubscriber(observer2);
		service.notifySubscriber();
	}
}
