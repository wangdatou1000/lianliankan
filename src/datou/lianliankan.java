package datou;

/*
 * lianliankan.java
 *
 * Created on 2007��4��4��, ����4:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Administrator
 */
public class lianliankan extends JFrame {
	private final String filename = "/images/", leix = ".gif", xipaijb = "洗牌", tisijb = "提示";
	private final Border bddianjise = BorderFactory.createLineBorder(Color.RED, 3);
	private final Border bdtisise = BorderFactory.createLineBorder(Color.blue, 3);
	private final Border bdyuanse = new JButton().getBorder();
	private final int fkgao = 45, fkkuan = 45, liesu = 10, hsu = 10, jiange = 1, cfusu = 3,
			txuansu = 25, tzongsu = 39;
	private final int leftdi = 0, updi = 0, rightdi = liesu, downdi = hsu;
	private final int down = 3, left = 0, up = 1, right = 2;
	private final int jptop = 75, jpleft = 85, jbheight = 40, jbwidth = 70, jlheight = 70,
			jlwidth = jpleft + 30;
	private int tisi, lifes;
	private int tisi1, tisi2;
	private JButton jb[];
	private boolean onefou;
	private int whichone;
	private Vector tuhao;
	private int p;
	private JMenu menu = new JMenu();
	private JMenuBar menubar = new JMenuBar();
	private JMenuItem menuitem = new JMenuItem();
	private JButton jbtisi;
	private JButton jbxipai;
	private JLabel jltisi;
	private JLabel jlxipai;
	public JPanel jp;
	public JLabel shijian;
	private JPanel dipan;
	private AudioClip music;

	public void cusihuabianliang() {
		p = 0;
		tisi = 8;
		lifes = 2;
		tisi1 = 0;
		tisi2 = 0;
		onefou = false;
		whichone = -1;
	}

	private JPanel getjp() {
		jp = new JPanel();
		jp.setSize(fkkuan * liesu, fkgao * hsu);
		jp.setBackground(java.awt.Color.black);
		jb = new JButton[liesu * hsu];
		for (int n = 0; n < liesu * hsu; n++) {
			jb[n] = new JButton();
			jb[n].setSize(fkkuan, fkgao);
			jb[n].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jbaction(e);
				}
			});
			jb[n].setActionCommand("" + n);
			jp.setLayout(new GridLayout(liesu, hsu, jiange, jiange));
			jp.add(jb[n]);
		}
		jp.setLocation(jpleft, jptop);
		return jp;
	}

	private JButton getjbtisi() {
		jbtisi = new JButton("提示");
		jbtisi.setForeground(Color.blue);
		jbtisi.setLocation(jpleft + (liesu + 1) * fkkuan, jptop);
		jbtisi.setSize(jbwidth, jbheight);
		jbtisi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtisiaction(evt);
			}
		});
		return jbtisi;
	}

	private JButton getjbxipai() {
		jbxipai = new JButton("洗牌");
		jbxipai.setForeground(Color.blue);
		jbxipai.setLocation(jpleft + (liesu + 1) * fkkuan, jptop + jbheight * 2);
		jbxipai.setSize(jbwidth, jbheight);
		jbxipai.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbxipaiaction(evt);
			}
		});
		return jbxipai;
	}

	private JLabel getjltisi() {
		jltisi = new javax.swing.JLabel();
		jltisi.setFont(new Font(tisijb, Font.BOLD, 16));
		jltisi.setForeground(Color.GREEN);
		jltisi.setSize(jlheight, jlwidth);
		jltisi.setLocation(10, jptop);
		return jltisi;
	}

	private JLabel getjlxipai() {
		jlxipai = new javax.swing.JLabel();
		jlxipai.setFont(new Font(xipaijb + lifes, 1, 16));
		jlxipai.setForeground(Color.GREEN);
		jlxipai.setLocation(10, jptop + jbheight * 2);
		jlxipai.setSize(jlheight, jlwidth);
		return jlxipai;
	}

	class dipan extends JPanel {
		private ImageIcon img;
		private String imgaddress = "/images/1.gif";

		public dipan() {
			img = new ImageIcon(imgaddress);
		}

		public void paintComponents(Graphics g) {

			super.paintComponents(g);
			img.paintIcon(dipan, g, 10, 10);
			// g.drawImage(img,0,0,dipan);
		}

	}

	private dipan getdipan() {
		dipan diban;
		diban = new dipan();
		diban.setLayout(null);
		diban.add(getjp());
		diban.add(getjltisi());
		diban.add(getjlxipai());
		diban.add(getjbtisi());
		diban.add(getjbxipai());

		diban.setBackground(Color.black);

		return diban;

	}

	public void cusihuajiemian() {
		this.setContentPane(getdipan());
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("连连看");
		menu.setText("\u83dc\u5355");
		menuitem.setText("\u63d0\u793a");
		menu.add(menuitem);
		menubar.add(menu);
		setJMenuBar(menubar);
		setLocation(150, 80);
		setSize(jbwidth + jpleft + fkkuan * (liesu + 2), jptop + fkgao * hsu + jbheight * 3 / 2);
		setResizable(false);

	}

	public lianliankan() {
		cusihuabianliang();
		cusihuajiemian();
		cusihua();
	}

	public void cusihua() {
		jltisi.setText(tisijb + tisi);
		jlxipai.setText(xipaijb + lifes);
		tuhao = (Vector) (xuantu(txuansu, tzongsu).clone());
		for (int n = 0; n < liesu * hsu; n++) {
			jb[n].setIcon(new javax.swing.ImageIcon(getClass().getResource(tu(n))));
			jb[n].setEnabled(true);
			jb[n].setVisible(true);
			jb[n].setBorder(bdyuanse);
		}
		jbxipai.setEnabled(true);
		jbtisi.setEnabled(true);
		if (!havexiao()) {
			xipai();
		}
	}

	public boolean samefou(int a, int b) {
		String sa, sb;
		sa = jb[a].getIcon().toString();
		sb = jb[b].getIcon().toString();
		return sa.equals(sb);
	}

	public boolean xiaofou(int a, int b) {
		int a_he = 0, a_lie = 0, b_he = 0, b_lie = 0;
		int x = 0;
		Vector va, vb;
		int a_cansu[] = new int[4];
		int b_cansu[] = new int[4];
		boolean kejianfou = true;

		if (a > b) {
			x = a;
			a = b;
			b = x;
		}
		a_he = a / liesu;
		a_lie = a % liesu;
		b_he = b / liesu;
		b_lie = b % liesu;
		va = getqi(a_he, a_lie);
		vb = getqi(b_he, b_lie);
		for (int n = 0; n < 4; n++) {
			a_cansu[n] = Integer.parseInt(va.get(n) + "");
			b_cansu[n] = Integer.parseInt(vb.get(n) + "");

		}
		for (int n = 0; n < 4; n++) {
			if (a_cansu[n] < 0 && b_cansu[n] < 0) {
				return true;
			}
		}
		b_cansu[right] = Math.abs(b_cansu[right]);
		a_cansu[right] = Math.abs(a_cansu[right]);
		b_cansu[left] = Math.abs(b_cansu[left]);
		a_cansu[left] = Math.abs(a_cansu[left]);
		b_cansu[up] = Math.abs(b_cansu[up]);
		a_cansu[up] = Math.abs(a_cansu[up]);
		b_cansu[down] = Math.abs(b_cansu[down]);
		a_cansu[down] = Math.abs(a_cansu[down]);
		if (a_he == b_he) {
			if ((a_cansu[right] == b_cansu[left]) && a_cansu[right] == b_lie - a_lie - 1) {
				return true;
			}
			if (waitongfou(a, b, b_cansu[up], a_cansu[up], 1, -1)) {
				return true;
			}

			if (waitongfou(a, b, b_cansu[down], a_cansu[down], 1, 1)) {
				return true;
			}
		}
		if (a_lie == b_lie) {
			if ((b_cansu[up] == a_cansu[down]) && b_cansu[up] == b_he - a_he - 1) {
				return true;
			}
			if (waitongfou(a, b, b_cansu[left], a_cansu[left], liesu, -1)) {
				return true;
			}
			if (waitongfou(a, b, b_cansu[right], a_cansu[right], liesu, 1)) {
				return true;
			}
		}
		// *********************************************************
		if (a_lie > b_lie && a_he != b_he) {
			int q1 = b_lie + a_cansu[left] - a_lie;
			int q2 = b_he - b_cansu[up];
			int q3 = b_cansu[left];
			int q4 = b_lie + a_he * liesu;
			int q5 = a_he;
			if (waice(q4, b, q1, q3, liesu, -1, q5, q2)) {
				return true;
			}
			q1 = b_lie + b_cansu[right] - a_lie;
			q2 = a_he + a_cansu[down];
			q3 = a_cansu[right];
			q4 = a_lie + b_he * liesu;
			q5 = b_he;
			if (waice(a, q4, q1, q3, liesu, 1, q2, q5)) {
				return true;
			}

			q1 = a_he + b_cansu[up] - b_he;
			q2 = b_lie + a_cansu[left];
			q3 = a_cansu[up];
			q4 = b_lie + a_he * liesu;
			q5 = a_lie;
			if (waice(q4, a, q1, q3, 1, -1, q2, q5)) {
				return true;
			}

			q1 = a_he + a_cansu[down] - b_he;
			q2 = b_lie + b_cansu[right];
			q3 = b_cansu[down];
			q4 = a_lie + b_he * liesu;
			q5 = a_lie;
			if (waice(b, q4, q1, q3, 1, 1, q2, q5)) {
				return true;
			}

			int nei = 0;
			if (b_cansu[right] >= a_lie - b_lie) {
				b_cansu[right] = a_lie - b_lie - 1;
			}
			if (a_cansu[left] >= a_lie - b_lie) {
				a_cansu[left] = a_lie - b_lie - 1;
			}
			nei = a_cansu[left] + b_cansu[right] - (a_lie - b_lie - 1);

			if (nei > 0) {
				q1 = b_lie + b_cansu[right] + a_he * liesu + 1;
				q2 = b + 1 + b_cansu[right];
				q3 = liesu;
				q4 = -1;
				if (waitongfou(q1, q2, nei, nei, q3, q4)) {
					return true;
				}
			}
			if (a_cansu[down] >= b_he - a_he) {
				a_cansu[down] = b_he - a_he - 1;
			}
			if (b_cansu[up] >= b_he - a_he) {
				b_cansu[up] = b_he - a_he - 1;
			}
			nei = a_cansu[down] + b_cansu[up] - (b_he - a_he - 1);
			if (nei > 0) {
				q1 = b - (b_cansu[up] - nei) * liesu;
				q2 = q1 + a_lie - b_lie;
				q3 = 1;
				q4 = -1;
				if (waitongfou(q1, q2, nei, nei, q3, q4)) {
					return true;
				}
			}

		}
		// ****************************************************************
		if (a_lie < b_lie && a_he != b_he) {
			int q1 = a_lie + b_cansu[left] - b_lie;
			int q2 = a_he + a_cansu[down];
			int q3 = a_cansu[left];
			int q4 = a_lie + b_he * liesu;
			int q5 = b_he;
			if (waice(a, q4, q1, q3, liesu, -1, q2, q5)) {
				return true;
			}
			q1 = a_lie + a_cansu[right] - b_lie;
			q2 = a_he + b_cansu[up];
			q3 = b_cansu[right];
			q4 = b_lie + a_he * liesu;
			q5 = b_he;
			if (waice(q4, b, q1, q3, liesu, 1, q2, q5)) {
				return true;
			}

			q1 = a_he + b_cansu[up] - b_he;
			q2 = a_lie + a_cansu[right];
			q3 = a_cansu[up];
			q4 = b_lie + a_he * liesu;
			q5 = b_lie;
			if (waice(a, q4, q1, q3, 1, -1, q2, q5)) {
				return true;
			}

			q1 = a_he + a_cansu[down] - b_he;
			q2 = a_lie + b_cansu[left];
			q3 = b_cansu[down];
			q4 = a_lie + b_he * liesu;
			q5 = b_lie;
			if (waice(q4, b, q1, q3, 1, 1, q2, q5)) {
				return true;
			}

			int nei = 0;
			if (a_cansu[right] >= b_lie - a_lie) {
				a_cansu[right] = b_lie - a_lie - 1;
			}
			if (b_cansu[left] >= b_lie - a_lie) {
				b_cansu[left] = b_lie - a_lie - 1;
			}
			nei = a_cansu[right] + b_cansu[left] - (b_lie - a_lie - 1);
			if (nei > 0) {
				q1 = a_lie + a_cansu[right] + a_he * liesu + 1;
				q2 = q1 + (b_he - a_he) * liesu;
				q3 = liesu;
				q4 = -1;
				if (waitongfou(q1, q2, nei, nei, q3, q4)) {
					return true;
				}
			}
			if (a_cansu[down] >= b_he - a_he) {
				a_cansu[down] = b_he - a_he - 1;
			}
			if (b_cansu[up] >= b_he - a_he) {
				b_cansu[up] = b_he - a_he - 1;
			}
			nei = a_cansu[down] + b_cansu[up] - (b_he - a_he - 1);

			if (nei > 0) {
				q1 = b - (b_cansu[up] - nei) * liesu;
				q2 = q1 - (b_lie - a_lie);
				q3 = 1;
				q4 = -1;

				if (waitongfou(q2, q1, nei, nei, q3, q4)) {
					return true;
				}
			}

		}

		return false;
	}

	public boolean waice(int a, int b, int q1, int q3, int bujin, int jiajian, int q2, int q4) {
		if (q1 >= 0) {
			if (q2 >= q4) {
				return true;
			}
			if ((q3 > 0) && q1 > 0) {
				if (waitongfou(a, b, q1, q3, bujin, jiajian)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean waitongfou(int a, int b, int ms1, int ms2, int bujin, int jiajian) {
		if (ms1 >= ms2) {
			ms1 = ms2;
		}
		for (int m = 1; m <= ms1; m++) {
			if (bujin == 1) {
				if (tongfou(a + m * liesu * jiajian, b + m * liesu * jiajian, bujin)) {
					return true;
				}
			} else {
				if (tongfou(a + m * jiajian, b + m * jiajian, bujin)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean tongfou(int tance1, int tance2, int buceng) {
		boolean kejianfou = true;
		for (int n = tance1; n < tance2; n = n + buceng) {
			kejianfou = jb[n].isVisible();
			if (kejianfou)
				return false;
		}
		return true;

	}

	public Vector getqi(int which_he, int which_lie) {
		Vector qi = new Vector();
		boolean kejianfou = true;
		int leftqi = 0, rightqi = 0, upqi = 0, downqi = 0;
		// **************************************************

		for (int p = which_lie - 1; p >= 0; p--) {
			kejianfou = jb[which_he * liesu + p].isVisible();

			if (kejianfou) {
				break;
			} else {

				leftqi += 1;

			}
		}
		if (leftqi == which_lie) {
			leftqi = -leftqi;
		}
		if (which_lie == 0) {
			leftqi = -liesu;
		}

		// *****************************************************

		for (int p = which_lie + 1; p < liesu; p++) {
			kejianfou = jb[which_he * liesu + p].isVisible();
			if (kejianfou) {
				break;
			} else {
				rightqi += 1;
			}
		}
		if (rightqi == liesu - which_lie - 1) {
			rightqi = -rightqi;
		}

		if (which_lie == liesu - 1) {
			rightqi = -liesu;
		}

		// *************************************************************
		for (int p = which_he - 1; p >= 0; p--) {
			kejianfou = jb[which_lie + liesu * p].isVisible();
			if (kejianfou) {
				break;
			} else {
				upqi += 1;
			}
		}
		if (upqi == which_he) {
			upqi = -upqi;
		}

		if (which_he == 0) {
			upqi = -hsu;
		}

		// *************************************************************
		for (int p = which_he + 1; p < hsu; p++) {
			kejianfou = jb[p * liesu + which_lie].isVisible();
			if (kejianfou) {
				break;
			} else {
				downqi += 1;
			}
		}
		if (downqi == hsu - which_he - 1) {
			downqi = -downqi;
		}

		if (which_he == hsu - 1) {
			downqi = -hsu;
		}

		// ***************************************************************

		qi.add(leftqi);
		qi.add(upqi);
		qi.add(rightqi);
		qi.add(downqi);
		qi.trimToSize();
		return qi;
	}

	public Vector xuantu(int xuansu, int zongsu) {
		Vector rongqi = new Vector();
		Vector rongqi2 = new Vector();
		int rdm = 0;
		for (int p = 1; p <= zongsu; p++) {
			rongqi.add(p);
		}
		for (int t = zongsu; t > zongsu - xuansu; t--) {
			rdm = (int) (Math.random() * t);
			rongqi2.add(rongqi.get(rdm));
			rongqi.remove(rdm);
		}
		int temp[] = new int[xuansu];
		for (int p = 0; p < xuansu; p++) {
			temp[p] = Integer.parseInt(rongqi2.get(p) + "");
		}

		for (int m = 0; m < xuansu; m++) {
			for (int n = 0; n < cfusu; n++) {
				rdm = (int) (Math.random() * (xuansu + n + m * cfusu));
				rongqi2.add(rdm, temp[m]);
			}

		}

		return rongqi2;
	}

	public String tu(int r) {
		String tudizi = filename + tuhao.get(r) + leix;
		return tudizi;
	}

	public boolean havexiao() {
		for (int n = 0; n < liesu * hsu - 1; n++) {
			if (jb[n].isVisible()) {
				for (int p = n + 1; p < liesu * hsu; p++) {
					if (jb[p].isVisible()) {
						if (samefou(n, p) && xiaofou(n, p)) {
							jb[tisi1].setBorder(bdyuanse);
							jb[tisi2].setBorder(bdyuanse);
							tisi1 = n;
							tisi2 = p;
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public void tisi() {
		jb[tisi1].setBorder(bdtisise);
		jb[tisi2].setBorder(bdtisise);

	}

	public void xipai() {
		Vector tupian = new Vector();
		Vector button = new Vector();
		for (int n = 0; n < liesu * hsu; n++) {
			if (jb[n].isVisible()) {
				tupian.add(jb[n].getIcon());
				button.add(jb[n]);
			}
		}
		button.trimToSize();
		tupian.trimToSize();
		int sumu = tupian.capacity();
		int rdm, rdm2;
		Object ob = new Object();
		for (int n = 0; n < sumu; n++) {
			rdm = (int) (Math.random() * sumu);
			rdm2 = (int) (Math.random() * sumu);
			ob = tupian.get(rdm);
			tupian.remove(rdm);
			tupian.add(rdm2, ob);
		}
		tupian.trimToSize();
		for (int n = 0; n < sumu; n++) {
			// System.out.println(button.get(n).getClass().toString());
			((JButton) (button.get(n))).setIcon((Icon) (tupian.get(n)));
		}
		if (!havexiao()) {
			xipai();
		}
	}

	public boolean xiaowanfou() {
		for (int n = 0; n < liesu * hsu; n++) {
			if (jb[n].isEnabled() == true) {
				return false;
			}
		}
		return true;
	}

	public static void gameover() {

	}

	private void close(java.awt.event.MouseEvent evt) {
		// System.exit(0);
	}

	private void jbxipaiaction(java.awt.event.ActionEvent evt) {
		if (lifes > 0) {
			xipai();
			lifes -= 1;
			jlxipai.setText(xipaijb + lifes);
			if (lifes < 1) {
				jbxipai.setEnabled(false);
			}
		}
	}

	private void jbtisiaction(java.awt.event.ActionEvent evt) {
		if (tisi > 0) {
			tisi -= 1;
			jltisi.setText(tisijb + tisi);
			if (tisi < 1) {
				jbtisi.setEnabled(false);
			}
			tisi();
		}
	}

	private void jbaction(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			int offset = Integer.parseInt(button.getActionCommand());
			if (jb[offset].getBorder() != bddianjise) {
				if (!onefou) {
					jb[offset].setBorder(bddianjise);
					onefou = true;
					whichone = offset;
				} else {
					if (samefou(whichone, offset) && xiaofou(whichone, offset)) {
						jb[whichone].setVisible(false);
						jb[whichone].setEnabled(false);
						jb[offset].setEnabled(false);
						jb[offset].setVisible(false);
						onefou = false;
						whichone = -1;
						if (xiaowanfou()) {
							JOptionPane.showMessageDialog(this, "��ϲ!!!���ѹ�����", "��ͷ��ʾ",
									JOptionPane.OK_OPTION);
							cusihuabianliang();
							cusihua();
						}
						if (!havexiao()) {
							if (lifes < 1) {
								int yesorno = JOptionPane.showConfirmDialog(null,
										"GAME OVER!!!!\nû�п���������!\n��ͷ!Ҫ��Ҫ����һ��ѽ?",
										"��ͷ��ʾ", JOptionPane.YES_OPTION);
								if (yesorno == 1) {
									System.exit(0);
								} else {
									cusihuabianliang();
									cusihua();
								}
							} else {
								xipai();
								lifes = lifes - 1;
								System.out.print(lifes);
								jlxipai.setText(xipaijb + lifes);
								if (lifes < 1) {
									jbxipai.setEnabled(false);
								}
							}
						}
					}
				}
			} else {
				jb[offset].setBorder(bdyuanse);
				onefou = false;
				whichone = -1;

			}

		}

	}

	public static void main(String args[]) {
		lianliankan tou = new lianliankan();
		tou.setVisible(true);
	}

}