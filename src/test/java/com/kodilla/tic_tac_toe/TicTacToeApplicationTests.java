package com.kodilla.tic_tac_toe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
class TicTacToeApplicationTests {

	@Test
	void testOWinsInRow0() {
		//Given
		Game game = new Game();

		//When
		game.makeMove(2, 2);
		game.makeMove(0, 0);
		game.makeMove(1, 1);
		game.makeMove(0, 1);
		game.makeMove(1, 2);
		game.makeMove(0, 2);

		//Then
		Assertions.assertEquals(GameStatusEnum.O, game.getState());
	}
	@Test
	void testOWinsInRow1() {
		//Given
		Game game = new Game();

		//When
		game.makeMove(2, 2);
		game.makeMove(1, 0);
		game.makeMove(0, 1);
		game.makeMove(1, 1);
		game.makeMove(2, 1);
		game.makeMove(1, 2);

		//Then
		Assertions.assertEquals(GameStatusEnum.O, game.getState());

	}
	@Test
	void testOWinsInRow2() {
		//Given
		Game game = new Game();

		//When
		game.makeMove(1,1);
		game.makeMove(2, 0);
		game.makeMove(0, 0);
		game.makeMove(2, 1);
		game.makeMove(0, 1);
		game.makeMove(2, 2);

		//Then
		Assertions.assertEquals(GameStatusEnum.O,game.getState());
	}
	@Test
	void testXWinsInRow0() {
		//Given
		Game game = new Game();

		//When
		game.makeMove(0, 0);
		game.makeMove(1, 1);
		game.makeMove(0, 1);
		game.makeMove(1, 2);
		game.makeMove(0, 2);

		//Then
		Assertions.assertEquals(GameStatusEnum.X, game.getState());
	}
	@Test
	void testXWinsInRow1() {
		//Given
		Game game = new Game();

		//When
		game.makeMove(1,0);
		game.makeMove(0, 1);
		game.makeMove(1,1);
		game.makeMove(0, 2);
		game.makeMove(1,2);

		//Then
		Assertions.assertEquals(GameStatusEnum.X, game.getState());
	}
	@Test
	void testXWinsInRow2() {
		//Given
		Game game = new Game();

		//When
		game.makeMove(2,0);
		game.makeMove(0, 1);
		game.makeMove(2,1);
		game.makeMove(0, 2);
		game.makeMove(2,2);

		//Then
		Assertions.assertEquals(GameStatusEnum.X, game.getState());
	}
	@Test
	void testDraw() {
		//Given
		Game game = new Game();



		//When
		game.makeMove(0,2);
		game.makeMove(0,0);
		game.makeMove(1,0);
		game.makeMove(0,1);
		game.makeMove(1,1);
		game.makeMove(1,2);
		game.makeMove(2,2);
		game.makeMove(2,0);
		game.makeMove(2,1);

		//OOX
 		//XXO
 		//OXX

		//Then
		Assertions.assertEquals(GameStatusEnum.DRAW, game.getState());
	}
	@Test
	void testInvalidMoveThrowsException() {
		//Given
		Game game = new Game();

		//When
		game.makeMove(0, 0);

		//Then
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			game.makeMove(0, 0);
		});
	}
}

