package tw.Tsen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

<<<<<<< HEAD
public class Main extends JFrame implements ActionListener, MouseMotionListener, MouseListener {
    static tw.Tsen.Main frm = new tw.Tsen.Main();
    static JButton player = new JButton("VS player");    //player1 VS player2
=======
public class Main extends JFrame implements ActionListener, MouseMotionListener, MouseListener{
    static tw.Tsen.Main frm = new tw.Tsen.Main();
    static JButton player  = new JButton("VS player");    //player1 VS player2
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
    static JButton computer = new JButton("VS computer"); //player VS computer
    static JButton restart = new JButton("Restart");      //重新開始
    static JButton theme = new JButton("Theme");          //背景主題
    static TextArea txa = new TextArea("Choose a game mode.", 1, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
    static JPanel toolbar = new JPanel();  // 工具列
<<<<<<< HEAD
    static Image bg[] = new Image[3];      // background
=======
    static Image bg[] = new Image[3];   //background
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1

    static int game_start; // 0:尚未開始  1: vs player  2: vs computer
    static Color chess[] = new Color[2];
    static int who; // who's turns
    static int board[][] = new int[13][13];  // 棋盤
<<<<<<< HEAD
    static int result[] = new int[4];        // (x1, y1) (x2, y2)
=======
    static int result[] = new int[4]; // (x1, y1) (x2, y2)
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
    static int move[][] = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};
    static int current_theme = 0;

    // 初始化遊戲狀態, 並根據需要指定遊戲模式
<<<<<<< HEAD
    public static void init(int... gameMode) {
=======
    public static void init(int... gameMode)
    {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
        game_start = (gameMode.length > 0) ? gameMode[0] : 0;  // 如果未提供值，預設為0
        who = 0;
        for (int i = 0; i < 13; ++i) for (int j = 0; j < 13; ++j) board[i][j] = 0;
    }

<<<<<<< HEAD
    public static void main(String args[]) {
        init();
        // bg儲存三種背景主題
        try {
            bg[0] = ImageIO.read(new File("img/wood.png"));
        } catch (Exception ex) {
            System.out.println("No image");
        }
        try {
            bg[1] = ImageIO.read(new File("img/sky.png"));
        } catch (Exception ex) {
            System.out.println("No image");
        }
        try {
            bg[2] = ImageIO.read(new File("img/forest.png"));
        } catch (Exception ex) {
            System.out.println("No image");
        }
=======
    public static void main(String args[])
    {
        init();
        // bg儲存三種背景主題
        try { bg[0] = ImageIO.read(new File("img/wood.png")); }
        catch(Exception ex) { System.out.println("No image"); }
        try { bg[1] = ImageIO.read(new File("img/sky.png")); }
        catch(Exception ex) { System.out.println("No image"); }
        try { bg[2] = ImageIO.read(new File("img/forest.png")); }
        catch(Exception ex) { System.out.println("No image"); }
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1

        // 控制棋子的顏色, 先手執黑棋, 後手執白棋
        chess[0] = Color.black;
        chess[1] = Color.white;

        // 右上角X能關閉視窗
<<<<<<< HEAD
        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
=======
        frm.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1

        // 設定視窗標題、大小、背景顏色
        frm.setTitle("Gobang");
        frm.setSize(800, 810);
        frm.setVisible(true);
<<<<<<< HEAD
        frm.setBackground(new Color(255, 255, 224));
=======
        frm.setBackground(new Color(255,255,224));
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1

        // 監聽滑鼠在視窗上的操作
        frm.addMouseListener(frm);
        frm.addMouseMotionListener(frm);

        /*在視窗(frm)中加入工具列(toolbar), toolbar布局設為FlowLayout
        將TextArea與4個button添加至工具列*/
        toolbar.setLayout(new FlowLayout());
        toolbar.add(txa);
        toolbar.add(player);
        toolbar.add(computer);
        toolbar.add(theme);
        toolbar.add(restart);

        // 當按下按鈕frm會捕捉到動作且執行相應程式
        player.addActionListener(frm);
        computer.addActionListener(frm);
        restart.addActionListener(frm);
        theme.addActionListener(frm);
        frm.add(toolbar, BorderLayout.SOUTH); // toolbar設在視窗底部
    }

<<<<<<< HEAD
    public boolean find_and_draw(int x, int y, int h) {
        Graphics2D g = (Graphics2D) getGraphics();
        int cur = 0;

        // 電腦產生的座標為(0~13,0~13), 所以要轉為點擊棋盤的座標
        if (h == 2) {
=======
    public boolean find_and_draw(int x, int y, int h)
    {
        // 先從視窗中取得繪圖物件, 才能在視窗上進行繪製
        Graphics2D g = (Graphics2D)getGraphics();
        int cur = 0;

        if (h == 2)   // 電腦產生的座標為(0~13,0~13), 所以要轉為點擊棋盤的座標
        {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
            x = x * 50 + 80;
            y = y * 50 + 80;
        }

<<<<<<< HEAD
        for (int i = 75, cnt_j = 0; i <= 675; i += 50, ++cnt_j) {
            for (int j = 75, cnt_i = 0; j <= 675; j += 50, ++cnt_i) {
                // 檢查是否可以下棋
                if (x >= j && x <= j + 50 && y >= i && y <= i + 50 && board[cnt_j][cnt_i] == 0) {
=======
        for (int i = 75, cnt_j = 0; i <= 675; i += 50, ++cnt_j)
            for (int j = 75, cnt_i = 0; j <= 675; j += 50, ++cnt_i)
                // 檢查是否可以下棋
                if (x >= j && x <= j + 50 && y >= i && y <= i + 50 && board[cnt_j][cnt_i] == 0)
                {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
                    cur = board[cnt_j][cnt_i] = who + 1;

                    // 繪製棋子顏色和外框
                    g.setColor(chess[who]);
                    g.fillOval(j + 5, i + 5, 40, 40);
                    who ^= 1;   //who進行XOR運算，who的值會在0和1之間切換
                    g.setColor(chess[who]);
                    g.drawOval(j + 5, i + 5, 40, 40);

                    // check if the game is end or not
<<<<<<< HEAD
                    if (isEnd(cnt_i, cnt_j, cur) == true) {
                        showWinnerImage(cur);
                    } else {
                        if (game_start == 1) {
                            if (cur == 1)
                                txa.setText("Player 1 goes (" + cnt_i + ", " + cnt_j + ")  It's Player 2's turn.");
                            else txa.setText("Player 2 goes (" + cnt_i + ", " + cnt_j + ")  It's Player 1's turn.");
                        } else {
                            if (cur == 1)
                                txa.setText("Player goes (" + cnt_i + ", " + cnt_j + ")  It's Computer's turn.");
                            else txa.setText("Computer goes (" + cnt_i + ", " + cnt_j + ")  It's Player's turn.");
=======
                    if (isEnd(cnt_i, cnt_j, cur) == true)
                    {
                        showWinnerImage(cur);
                    }
                    else
                    {
                        if (game_start == 1)
                        {
                            if (cur == 1) txa.setText("Player 1 goes (" + cnt_i + ", " + cnt_j  + ")  It's Player 2's turn.");
                            else txa.setText("Player 2 goes (" + cnt_i + ", " + cnt_j  + ")  It's Player 1's turn.");
                        }
                        else
                        {
                            if (cur == 1) txa.setText("Player goes (" + cnt_i + ", " + cnt_j  + ")  It's Computer's turn.");
                            else txa.setText("Computer goes (" + cnt_i + ", " + cnt_j  + ")  It's Player's turn.");
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
                        }
                    }
                    return true;
                }
<<<<<<< HEAD
            }
        }
=======
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
        return false;
    }

    // 在遊戲結束時顯示獲勝者的圖片
    private void showWinnerImage(int winner) {
        ImageIcon icon = null;
<<<<<<< HEAD
        if (game_start == 1) {
=======
        if (game_start == 1)
        {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
            if (winner == 1) {   // player1 wins
                try {
                    Image img = ImageIO.read(new File("img/player1.png"));
                    icon = new ImageIcon(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
<<<<<<< HEAD
            } else {     // player2 wins
=======
            }
            else{     // player2 wins
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
                try {
                    Image img = ImageIO.read(new File("img/player2.png"));
                    icon = new ImageIcon(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
<<<<<<< HEAD
        } else if (game_start == 2) {
=======
        }
        else if (game_start == 2)
        {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
            if (winner == 1) {    // player wins
                try {
                    Image img = ImageIO.read(new File("img/win.png"));
                    icon = new ImageIcon(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
<<<<<<< HEAD
            } else {     // computer wins
=======
            }
            else{     // computer wins
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
                try {
                    Image img = ImageIO.read(new File("img/lose.png"));
                    icon = new ImageIcon(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // Create a JOptionPane to display the image
        if (icon != null) {
            JOptionPane.showMessageDialog(this, icon, "Who is Winner", JOptionPane.PLAIN_MESSAGE);
        }

        // Ask the user if they want to start a new game(同一個遊戲模式)
        int choice = JOptionPane.showConfirmDialog(this, "Start a new game?", "New Game", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            init(game_start); // Initialize a new game with the current game mode
            repaint(); // Repaint the board
<<<<<<< HEAD
        } else game_start = 0;
    }

    public static boolean isEnd(int x, int y, int cur) {
        for (int i = 0; i < 4; ++i) {
            int cnt = 0;

            for (int j = -4; j <= 4; ++j) {
=======
        }
        else game_start = 0;
    }

    public static boolean isEnd(int x, int y, int cur)
    {
        for (int i = 0; i < 4; ++i)
        {
            int cnt = 0;

            for (int j = -4; j <= 4; ++j)
            {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
                int nx = x + move[i][0] * j;
                int ny = y + move[i][1] * j;

                if (nx >= 0 && nx < 13 && ny >= 0 && ny < 13 && board[ny][nx] == cur) ++cnt;
                else cnt = 0;

<<<<<<< HEAD
                if (cnt == 1) {
                    result[0] = nx;
                    result[1] = ny;
                } else if (cnt == 5) {
=======
                if (cnt == 1)
                {
                    result[0] = nx;
                    result[1] = ny;
                }
                else if (cnt == 5)
                {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
                    result[2] = nx;
                    result[3] = ny;
                    return true;
                }
            }
        }
        return false;
    }

<<<<<<< HEAD
    public void get_computer(int[] pos) {
=======
    public void get_computer(int[] pos)
    {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
        int best_attack[] = new int[2];
        int best_defence[] = new int[2];
        int tmp1[] = new int[2];
        int tmp2[] = new int[2];

<<<<<<< HEAD
        for (int i = 0; i < 13; ++i)
            for (int j = 0; j < 13; ++j) {
                if (board[i][j] != 0) continue;

                // 取得攻擊及防守分數
                int c_ = score(j, i, 2);
                int p_ = score(j, i, 1);

            /*紀錄最佳攻擊與防守的座標, 有兩種方法
            1.攻擊為主, 防守為輔  2.防守為主, 攻擊為輔*/
                if (c_ > best_attack[0] || (c_ == best_attack[0] && p_ > best_attack[1])) {
                    best_attack[0] = c_;
                    best_attack[1] = p_;
                    tmp1[0] = j;
                    tmp1[1] = i;
                }
                if (p_ > best_defence[0] || (p_ == best_defence[0] && c_ > best_defence[1])) {
                    best_defence[0] = p_;
                    best_defence[1] = c_;
                    tmp2[0] = j;
                    tmp2[1] = i;
                }
            }

        // 優先採取主要分數較高的那個點
        if (best_attack[0] > best_defence[0]) {
            pos[0] = tmp1[0];
            pos[1] = tmp1[1];
        } else if (best_defence[0] > best_attack[0]) {
=======
        for (int i = 0; i < 13; ++i) for (int j = 0 ; j < 13; ++j)
        {
            if (board[i][j] != 0) continue;

            // 取得攻擊及防守分數
            int c_ = score(j, i, 2);
            int p_ = score(j, i, 1);

            /*紀錄最佳攻擊與防守的座標, 有兩種方法
            1.攻擊為主, 防守為輔  2.防守為主, 攻擊為輔*/
            if (c_ > best_attack[0] || (c_ == best_attack[0] && p_ > best_attack[1]))
            {
                best_attack[0] = c_;
                best_attack[1] = p_;
                tmp1[0] = j;
                tmp1[1] = i;
            }
            if (p_ > best_defence[0] || (p_ == best_defence[0] && c_ > best_defence[1]))
            {
                best_defence[0] = p_;
                best_defence[1] = c_;
                tmp2[0] = j;
                tmp2[1] = i;
            }
        }
        
        // 優先採取主要分數較高的那個點
        if (best_attack[0] > best_defence[0])
        {
            pos[0] = tmp1[0];
            pos[1] = tmp1[1];
        }
        else if (best_defence[0] > best_attack[0])
        {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
            pos[0] = tmp2[0];
            pos[1] = tmp2[1];
        }
        // 如果主要分數相同, 則採取輔分數較高的那個點(攻擊優先)
<<<<<<< HEAD
        else if (best_attack[1] >= best_defence[1]) {
            pos[0] = tmp1[0];
            pos[1] = tmp1[1];
        } else {
=======
        else if (best_attack[1] >= best_defence[1])
        {
            pos[0] = tmp1[0];
            pos[1] = tmp1[1];
        }
        else
        {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
            pos[0] = tmp2[0];
            pos[1] = tmp2[1];
        }
    }

<<<<<<< HEAD
    public int score(int x, int y, int cur) {
=======
    public int score(int x, int y, int cur)
    {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
        int opposite = (cur == 1 ? 2 : 1);
        int five = 0;
        int four_alive = 0, four_die1 = 0, four_die2 = 0;
        int three_alive1 = 0, three_alive2 = 0, three_die = 0;
        int two_alive = 0, two_die = 0;

<<<<<<< HEAD
        for (int i = 0; i < 4; ++i) {
=======
        for (int i = 0; i < 4; ++i)  // 尋找四個方向
        {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
            int cnt = 1;
            int l = 0, r = 0;
            int left[] = new int[4];
            int right[] = new int[4];

            // find right
<<<<<<< HEAD
            for (int j = 1; j <= 4; ++j) {
=======
            for (int j = 1; j <= 4; ++j)
            {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
                int nx = x + move[i][0] * j;
                int ny = y + move[i][1] * j;

                if (nx >= 0 && nx < 13 && ny >= 0 && ny < 13 && board[ny][nx] == cur) ++cnt;
<<<<<<< HEAD
                else {
=======
                else
                {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
                    r = j;
                    break;
                }
            }

            // find left
<<<<<<< HEAD
            for (int j = -1; j >= -4; --j) {
=======
            for (int j = -1; j >= -4; --j)
            {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
                int nx = x + move[i][0] * j;
                int ny = y + move[i][1] * j;

                if (nx >= 0 && nx < 13 && ny >= 0 && ny < 13 && board[ny][nx] == cur) ++cnt;
<<<<<<< HEAD
                else {
=======
                else
                {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
                    l = j;
                    break;
                }
            }

            // get left and right array
<<<<<<< HEAD
            for (int j = 0; j < 4; ++j, --l, ++r) {
=======
            for (int j = 0; j < 4; ++j, --l, ++r)
            {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
                int nx = x + move[i][0] * l;
                int ny = y + move[i][1] * l;
                if (nx >= 0 && nx < 13 && ny >= 0 && ny < 13) left[j] = board[ny][nx];
                else left[j] = opposite;

                nx = x + move[i][0] * r;
                ny = y + move[i][1] * r;
                if (nx >= 0 && nx < 13 && ny >= 0 && ny < 13) right[j] = board[ny][nx];
                else right[j] = opposite;
            }

            // 判斷為哪一種棋型
            if (cnt == 5) ++five;
<<<<<<< HEAD
            else if (cnt == 4) {
                if (left[0] == 0 && right[0] == 0) ++four_alive; // _oooo_
                else if (left[0] == 0 || right[0] == 0) ++four_die1; // _oooo, oooo_
            } else if (cnt == 3) {
                if ((left[0] == 0 && left[1] == cur) || (right[0] == 0 && right[1] == cur)) ++four_die2; // o_ooo, ooo_o
                else if (left[0] == 0 && right[0] == 0 && (left[1] == 0 || right[1] == 0))
                    ++three_alive1; // __ooo_, _ooo__
                else if ((left[0] == 0 && left[1] == 0) || (right[0] == 0 && right[1] == 0))
                    ++three_die; // __ooo, ooo__
                else if (left[0] == 0 && right[0] == 0) ++three_die; // _ooo_
            } else if (cnt == 2) {
                if ((left[0] == 0 && left[1] == cur && left[2] == cur) || (right[0] == 0 && right[1] == cur && right[2] == cur))
                    ++four_die2; // oo_oo
                else if ((left[0] == 0 && right[0] == 0) && (left[1] == cur && left[2] == 0) || (right[1] == cur && right[2] == 0))
                    ++three_alive2; // _o_oo_, _oo_o_
                else if ((left[0] == 0 && left[1] == cur && left[2] == 0) || (right[0] == 0 && right[1] == cur && right[2] == 0))
                    ++three_die; //_o_oo, oo_o_
                else if ((left[0] == 0 && left[1] == 0 && left[2] == cur) || (right[0] == 0 && right[1] == 0 && right[2] == cur))
                    ++three_die; // o__oo, oo__o
                else if (left[0] == 0 && right[0] == 0 && (left[1] == 0 && left[2] == 0) || (left[1] == 0 && right[1] == 0) || (right[1] == 0 && right[2] == 0))
                    ++two_alive; // _oo___, __oo__, ___oo_
                else if ((left[0] == 0 && left[1] == 0 && left[2] == 0) && (right[0] == 0 && right[1] == cur && right[2] == 0))
                    ++two_die; // ___oo, oo___
            } else if (cnt == 1) {
                if ((left[0] == 0 && left[1] == cur && left[2] == cur && left[3] == cur) || (right[0] == 0 && right[1] == cur && right[2] == cur && right[3] == cur))
                    ++four_die2; // ooo_o, o_ooo
                else if ((left[0] == 0 && right[0] == 0) && ((left[1] == cur && left[2] == cur && left[3] == 0) || (right[1] == cur && right[2] == cur && right[3] == 0)))
                    ++three_alive2; // _oo_o_, _o_oo_
                else if (left[0] == 0 && right[0] == 0 && ((left[1] == cur && left[2] == cur) || (right[1] == cur && right[2] == cur)))
                    ++three_die; // oo_o_, _o_oo
                else if ((left[0] == 0 && left[1] == cur && left[2] == cur && left[3] == 0) || (right[0] == 0 && right[1] == cur && right[2] == cur && right[3] == 0))
                    ++three_die; // _oo_o, o_oo_
                else if ((left[0] == 0 && left[1] == 0 && left[2] == cur && left[3] == cur) || (right[0] == 0 && right[1] == 0 && right[2] == cur && right[3] == cur))
                    ++three_die; // oo__o, o__oo
                else if ((left[0] == 0 && left[1] == cur && left[2] == 0 && left[3] == cur) || (right[0] == 0 && right[1] == cur && right[2] == 0 && right[3] == cur))
                    ++three_die; // o_o_o
=======
            else if (cnt == 4)
            {
                if (left[0] == 0 && right[0] == 0) ++four_alive; // _oooo_
                else if (left[0] == 0 || right[0] == 0) ++four_die1; // _oooo, oooo_
            }
            else if (cnt == 3)
            {
                if ((left[0] == 0 && left[1] == cur) || (right[0] == 0 && right[1] == cur)) ++four_die2; // o_ooo, ooo_o
                else if  (left[0] == 0 && right[0] == 0 && (left[1] == 0 || right[1] == 0)) ++three_alive1; // __ooo_, _ooo__
                else if ((left[0] == 0 && left[1] == 0) || (right[0] == 0 && right[1] == 0)) ++three_die; // __ooo, ooo__
                else if (left[0] == 0 && right[0] == 0) ++three_die; // _ooo_
            }
            else if (cnt == 2)
            {
                if ((left[0] == 0 && left[1] == cur && left[2] == cur) || (right[0] == 0 && right[1] == cur && right[2] == cur)) ++four_die2; // oo_oo
                else if ((left[0] == 0 && right[0] == 0) && (left[1] == cur && left[2] == 0) || (right[1] == cur && right[2] == 0)) ++three_alive2; // _o_oo_, _oo_o_
                else if ((left[0] == 0 && left[1] == cur && left[2] == 0) || (right[0] == 0 && right[1] == cur && right[2] == 0)) ++three_die; //_o_oo, oo_o_
                else if ((left[0] == 0 && left[1] == 0 && left[2] == cur) || (right[0] == 0 && right[1] == 0 && right[2] == cur)) ++three_die; // o__oo, oo__o
                else if (left[0] == 0 && right[0] == 0 && (left[1] == 0 && left[2] == 0) || (left[1] == 0 && right[1] == 0) || (right[1] == 0 && right[2] == 0)) ++two_alive; // _oo___, __oo__, ___oo_
                else if ((left[0] == 0 && left[1] == 0 && left[2] == 0) && (right[0] == 0 && right[1] == cur && right[2] == 0)) ++two_die; // ___oo, oo___
            }
            else if (cnt == 1)
            {
                if ((left[0] == 0 && left[1] == cur && left[2] == cur && left[3] == cur) || (right[0] == 0 && right[1] == cur && right[2] == cur && right[3] == cur)) ++four_die2; // ooo_o, o_ooo
                else if ((left[0] == 0 && right[0] == 0) && ((left[1] == cur && left[2] == cur && left[3] == 0) || ( right[1] == cur && right[2] == cur && right[3] == 0))) ++three_alive2; // _oo_o_, _o_oo_
                else if (left[0] == 0 && right[0] == 0 && ((left[1] == cur && left[2] == cur) || (right[1] == cur && right[2] == cur))) ++three_die; // oo_o_, _o_oo
                else if ((left[0] == 0 && left[1] == cur && left[2] == cur && left[3] == 0) || (right[0] == 0 && right[1] == cur && right[2] == cur && right[3] == 0)) ++three_die; // _oo_o, o_oo_
                else if ((left[0] == 0 && left[1] == 0 && left[2] == cur && left[3] == cur) || (right[0] == 0 && right[1] == 0 && right[2] == cur && right[3] == cur)) ++three_die; // oo__o, o__oo
                else if ((left[0] == 0 && left[1] == cur && left[2] == 0 && left[3] == cur) || (right[0] == 0 && right[1] == cur && right[2] == 0 && right[3] == cur)) ++three_die; // o_o_o
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
            }
        }

        if (five >= 1) return 100; // ooooo
<<<<<<< HEAD
        else if (four_alive >= 1 || (four_die1 + four_die2) >= 2 || ((four_die1 + four_die2) >= 1 && (three_alive1 + three_alive2) >= 1))
            return 13;
        else if ((three_alive1 + three_alive2) >= 2) return 12;
=======
        else if (four_alive >= 1 || (four_die1 + four_die2) >= 2 || ((four_die1 + four_die2) >= 1 && (three_alive1 + three_alive2) >= 1)) return 13;
        else if ((three_alive1 + three_alive2)  >= 2) return 12;
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
        else if (three_alive1 >= 1 && (four_die1 + four_die2) >= 1) return 11;
        else if (three_alive2 >= 1 && (four_die1 + four_die2) >= 1) return 10;
        else if (three_alive1 >= 1) return 9;
        else if (three_alive2 >= 1) return 8;
        else if (four_die1 >= 1) return 7;
        else if (four_die2 >= 1) return 6;
        else if (two_alive >= 2) return 5;
        else if (two_alive >= 1) return 4;
        else if (three_die >= 1) return 3;
        else if (two_die >= 1) return 2;
        else return 1;
    }

<<<<<<< HEAD
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
=======
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1

        // 繪製背景
        g2.drawImage(bg[current_theme], 50, 50, 700, 700, null);

        // 設定線條粗細為 2px 和顏色
        g2.setStroke(new BasicStroke(2));
        if (current_theme == 0) g2.setColor(Color.black);
        else if (current_theme == 1) g2.setColor(Color.white);

<<<<<<< HEAD
        for (int i = 100; i <= 700; i += 50) {
            g2.drawLine(i, 100, i, 700);
            g2.drawLine(100, i, 700, i);
        }

=======
        for (int i = 100; i <= 700; i += 50)
        {
            g2.drawLine(i, 100, i, 700);
            g2.drawLine(100, i, 700, i);
        }
        // 繪製黑點
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
        g2.fillOval(245, 245, 12, 12); // 左上
        g2.fillOval(545, 545, 12, 12); // 右下
        g2.fillOval(245, 545, 12, 12); // 左下
        g2.fillOval(545, 245, 12, 12); // 右上
        g2.fillOval(245, 395, 12, 12); // 左邊
        g2.fillOval(395, 245, 12, 12); // 上邊
        g2.fillOval(545, 395, 12, 12); // 右邊
        g2.fillOval(395, 545, 12, 12); // 下邊
        g2.fillOval(395, 395, 12, 12); // 天元
    }

<<<<<<< HEAD
    public void actionPerformed(ActionEvent e) {
        JButton B = (JButton) e.getSource();  // 知道按下的按鈕

        if (game_start == 0 && B == player) {
            txa.setText("Player vs player. Game started! Black turn.");
            game_start = 1;
        } else if (game_start == 0 && B == computer) {
            txa.setText("Player vs computer. Game started! Black turn.");
            game_start = 2;
        } else if (B == restart) {
            txa.setText("Game restart. Choose a game mode.");
            init();
            repaint();
        } else if (game_start == 0 && B == theme) {
=======
    public void actionPerformed(ActionEvent e)
    {
        JButton B = (JButton) e.getSource();  // 知道按下的按鈕

        if (game_start == 0 && B == player)
        {
            txa.setText("Player vs player. Game started! Black turn.");
            game_start = 1;
        }
        else if (game_start == 0 && B == computer)
        {
            txa.setText("Player vs computer. Game started! Black turn.");
            game_start = 2;
        }
        else if (B == restart)
        {
            txa.setText("Game restart. Choose a game mode.");
            init();
            repaint();
        }
        else if (game_start == 0 && B == theme)
        {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
            // 切換背景
            current_theme = (current_theme + 1) % 3;
            repaint();  //重新繪製視窗來更新背景
        }
    }

<<<<<<< HEAD
    public void mouseClicked(MouseEvent e) {
        if (game_start == 0) return;  // 遊戲尚未開始則滑鼠點擊無效

        //根據滑鼠點擊的位置放棋子
        if (find_and_draw(e.getX(), e.getY(), 1) && game_start == 2) {
=======
    public void mouseClicked(MouseEvent e)
    {
        if (game_start == 0) return;  // 遊戲尚未開始則滑鼠點擊無效

        //根據滑鼠點擊的位置放棋子
        if (find_and_draw(e.getX(), e.getY(), 1) && game_start == 2)
        {
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
            // 假設是player vs computer, computer會放一個棋子
            int pos[] = new int[2];
            get_computer(pos);
            find_and_draw(pos[0], pos[1], 2);
        }

        // Check if the board is full and there is no winner
        boolean isBoardFull = true;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (board[i][j] == 0) {
                    isBoardFull = false;
                    break;
                }
            }
            if (!isBoardFull) break;
        }
        if (isBoardFull) showDrawImage(); // Display draw image
    }
<<<<<<< HEAD

=======
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
    private void showDrawImage() {
        ImageIcon icon = null;
        try {
            Image img = ImageIO.read(new File("img/tie.png"));
            icon = new ImageIcon(img);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a JOptionPane to display the draw image
        if (icon != null) {
            JOptionPane.showMessageDialog(this, icon, "Draw", JOptionPane.PLAIN_MESSAGE);
        }

        // Ask the user if they want to start a new game
        int choice = JOptionPane.showConfirmDialog(this, "Start a new game?", "New Game", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            init(game_start); // Initialize a new game with the current game mode
<<<<<<< HEAD
            repaint();        // Repaint the board
        }
    }

    public void mouseMoved(MouseEvent e) {}     // 滑鼠移動時

    public void mouseReleased(MouseEvent e) {}  // 滑鼠放開時

    public void mouseEntered(MouseEvent e) {}   // 滑鼠進入物件時

    public void mouseExited(MouseEvent e) {}    // 滑鼠離開物件時

    public void mouseDragged(MouseEvent e) {}   // 滑鼠拖動時

    public void mousePressed(MouseEvent e) {}   // 滑鼠按下時
=======
            repaint(); // Repaint the board
        }
    }
    public void mouseMoved(MouseEvent e){}     // 滑鼠移動時
    public void mouseReleased(MouseEvent e){}  // 滑鼠放開時
    public void mouseEntered(MouseEvent e){}   // 滑鼠進入物件時
    public void mouseExited(MouseEvent e){}    // 滑鼠離開物件時
    public void mouseDragged(MouseEvent e){}   // 滑鼠拖動時
    public void mousePressed(MouseEvent e){}   // 滑鼠按下時
>>>>>>> 3ffae28d777d029eae8f57fa3a68af686d139ba1
}