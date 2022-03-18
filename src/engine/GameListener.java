package engine;

public interface GameListener {
	void onEndTurn();
	void onAutoResolve();
	void onOccupy();
	void onIsGameOver();

}
