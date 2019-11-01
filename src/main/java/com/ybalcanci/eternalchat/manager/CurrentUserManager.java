package com.ybalcanci.eternalchat.manager;

import com.ybalcanci.eternalchat.model.User;

public interface CurrentUserManager {
	User getCurrentUser();
	void login();
}
