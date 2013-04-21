package com.gao.rest.services.framework;

import com.gao.rest.serices.pojos.GAOResponse;

public interface WSLogin {
	GAOResponse authenticate(String username, String password);
	void forgotPassword(String username);
}
