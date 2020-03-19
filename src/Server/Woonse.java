package Server;

import java.util.Random;

public class Woonse {
private static final String[] ws= {
		"짜장면",
		"금식",
		"사람 조심하세요.",
		"투자는 금물",
		"무모한 집착이 주의되는 하루입니다."
};

  public String selWoonse() {
	  return ws[new Random().nextInt(ws.length)];
  }
}
