package Server;

import java.util.Random;

public class Woonse {
private static final String[] ws= {
		"¥���",
		"�ݽ�",
		"��� �����ϼ���.",
		"���ڴ� �ݹ�",
		"������ ������ ���ǵǴ� �Ϸ��Դϴ�."
};

  public String selWoonse() {
	  return ws[new Random().nextInt(ws.length)];
  }
}
