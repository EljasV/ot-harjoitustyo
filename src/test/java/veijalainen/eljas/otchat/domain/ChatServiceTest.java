package veijalainen.eljas.otchat.domain;

import org.junit.Before;
import org.junit.Test;
import veijalainen.eljas.otchat.dao.ConfigMemoryDao;
import veijalainen.eljas.otchat.dao.MessageMemoryDao;
import veijalainen.eljas.otchat.dao.UserMemoryDao;
import veijalainen.eljas.otchat.util.Result;

import static org.junit.Assert.*;

public class ChatServiceTest {
	ChatService chatService;

	@Before
	public void setup() {
		chatService = new ChatService(new UserMemoryDao(), new MessageMemoryDao(), new ConfigMemoryDao());
	}


	@Test
	public void createUserWithSameUsername() {
		chatService.createUser("Aatami", "cba321", "cba321");
		Result<Void, ChatService.CreateUserErrorCode> result = chatService.createUser("Aatami", "aaaaa", "aaaaa");
		assertFalse(result.success());
		assertEquals(ChatService.CreateUserErrorCode.USERNAME_EXISTS, result.getError());
	}

	@Test
	public void createUserDifferentPassword() {
		Result<Void, ChatService.CreateUserErrorCode> result = chatService.createUser("Bea", "123aaaaa", "321aaaaa");
		assertFalse(result.success());
		assertEquals(ChatService.CreateUserErrorCode.DIFFERENT_PASSWORDS, result.getError());
	}

	@Test
	public void createUserIllegalPassword() {
		Result<Void, ChatService.CreateUserErrorCode> result = chatService.createUser("Charlie", "1", "1");
		assertFalse(result.success());
		assertEquals(ChatService.CreateUserErrorCode.ILLEGAL_PASSWORD, result.getError());
	}

	@Test
	public void createUserSuccessfully() {
		Result<Void, ChatService.CreateUserErrorCode> result = chatService.createUser("Daavid", "a1b2c3d4e5f6g7", "a1b2c3d4e5f6g7");
		assertTrue(result.success());
	}

	@Test
	public void loginSuccessfully() {
		String name = "Emma";
		String password = "mahtava_salasana";
		chatService.createUser(name, password, password);

		Result<Session, Void> result = chatService.login(name, password);

		assertTrue(result.success());
		assertEquals(new User(name, password), result.get().getUser());
	}

	@Test
	public void loginInvalidName() {
		String name = "Fanni";
		String password = "aaaaa";
		chatService.createUser(name, password, password);

		Result<Session, Void> result = chatService.login("Anni", password);

		assertFalse(result.success());
	}

	@Test
	public void loginInvalidPassword() {
		String name = "Gabriel";
		String password = ";;;;;;";
		chatService.createUser(name, password, password);

		Result<Session, Void> result = chatService.login(name, "123");
		assertFalse(result.success());
	}

}