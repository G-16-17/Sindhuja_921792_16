package com.learn.mediator;
public interface IChatMediator {

	public void AddUser(IUser user);
	public void sendMessage(String name, String msg, IUser user);
}
