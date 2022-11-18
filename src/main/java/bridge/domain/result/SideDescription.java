package bridge.domain.result;

import bridge.domain.game.BridgeGame;
import bridge.domain.player.MovementCommand;

import java.util.Arrays;
import java.util.List;

public enum SideDescription {

	upperSide("U", BridgeGame.upperBridge, BridgeGame.underBridge),
	downSide("D", BridgeGame.underBridge, BridgeGame.upperBridge);

	private final String sideSymbol;
	private final List<String> side;
	private final List<String> otherSide;

	SideDescription(String sideSymbol, List<String> side, List<String> otherSide) {
		this.sideSymbol = sideSymbol;
		this.side = side;
		this.otherSide = otherSide;
	}

	public static SideDescription of(MovementCommand movementCommand) {
		return Arrays.stream(values())
				.filter(checkSide -> checkSide.sideSymbol.equals(movementCommand.side()))
				.findFirst()
				.orElseThrow(IllegalAccessError::new);
	}

	public List<String> getSide() {
		return side;
	}

	public List<String> getOtherSide() {
		return otherSide;
	}
}

