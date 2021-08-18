package com.learn.mediator;

public class Client {

	public static void main(String[] args) {
		ChatMediator chatMediator = new ChatMediator();
		BasicUser bu = new BasicUser("Sindhu", chatMediator);
		PremiumUser pu1 = new PremiumUser("Pranee", chatMediator);
		PremiumUser pu2 = new PremiumUser("Usika", chatMediator);
		// chatMediator.AddUser(bu);
		chatMediator.AddUser(pu1);
		chatMediator.AddUser(pu2);
		String name = bu.getName();

		bu.SendMessage(name, "Hi ppl");
	}
}