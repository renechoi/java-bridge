package bridge.domain.player;

import bridge.view.InputException;
import bridge.view.InputValidator;

public class BridgeSize implements InputValidator {

	private static final int BRIDGE_SIZE_MIN = 3;
	private static final int BRIDGE_SIZE_MAX = 20;

	private final int bridgeSize;

	public BridgeSize(int bridgeSize) {
		validate(bridgeSize);
		this.bridgeSize = bridgeSize;
	}

	@Override
	public void validate(Integer inputBridgeSize) {
		isNumberInBetween(inputBridgeSize);
	}

	public static BridgeSize valueOf(String inputBridgeSize) {
		try {
			return new BridgeSize(Integer.parseInt(inputBridgeSize));
		} catch (NumberFormatException e) {
			throw new InputException(InputException.NOT_A_NUMBER);
		}
	}

	private void isNumberInBetween(int inputBridgeLength) {
		if (inputBridgeLength < BRIDGE_SIZE_MIN || inputBridgeLength > BRIDGE_SIZE_MAX) {
			throw new InputException(String.format(InputException.NOT_IN_BETWEEN_PROPER_RANGE, BRIDGE_SIZE_MIN, BRIDGE_SIZE_MAX));
		}
	}

	public int toNumber() {
		return bridgeSize;
	}

	@Override
	public void validate(String value) {
	}
}
