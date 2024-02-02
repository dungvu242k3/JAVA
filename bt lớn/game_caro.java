
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CaRo extends JFrame implements ActionListener {

    private String playerXName;
    private String playerOName;
    private String winner;

    Color background_cl = Color.white;
    Color x_cl = Color.red;
    Color o_cl = Color.blue;
    int column = 20, row = 30, count = 0;
    int xUndo[] = new int[column * row];
    int yUndo[] = new int[column * row];
    boolean tick[][] = new boolean[column + 2][row + 2];
    int Size = 0;
    Container cn;
    JPanel pn, pn2;
    JLabel lb, playerLabel;
    JButton newGame_bt, undo_bt, exit_bt;
    JCheckBox switchMode_cb;
    private JButton b[][] = new JButton[column + 2][row + 2];
    boolean isVsComputer = false;

    public CaRo(String s) {
        super(s);
        cn = this.getContentPane();
        pn = new JPanel();
        pn.setLayout(new GridLayout(column, row));

        getPlayerNames();

        for (int i = 0; i <= column + 1; i++) {
            for (int j = 0; j <= row + 1; j++) {
                b[i][j] = new JButton(" ");
                b[i][j].setActionCommand(i + " " + j);
                b[i][j].setBackground(background_cl);
                b[i][j].addActionListener(this);
                tick[i][j] = true;
            }
        }

        for (int i = 1; i <= column; i++) {
            for (int j = 1; j <= row; j++) {
                pn.add(b[i][j]);
            }
        }

        lb = new JLabel(playerXName + " Đánh Trước");
        playerLabel = new JLabel("Người Chơi: " + playerXName);
        newGame_bt = new JButton("New Game");
        undo_bt = new JButton("Undo");
        exit_bt = new JButton("Exit");

        switchMode_cb = new JCheckBox("Play vs Computer");
        switchMode_cb.addActionListener(this);

        newGame_bt.addActionListener(this);
        undo_bt.addActionListener(this);
        exit_bt.addActionListener(this);

        exit_bt.setForeground(x_cl);
        cn.add(pn);

        pn2 = new JPanel();
        pn2.setLayout(new FlowLayout());
        pn2.add(lb);
        pn2.add(playerLabel);
        pn2.add(newGame_bt);
        pn2.add(undo_bt);
        pn2.add(exit_bt);
        pn2.add(switchMode_cb);
        cn.add(pn2, "North");

        this.setVisible(true);
        this.setSize(1400, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        undo_bt.setEnabled(false);
    }

    private void getPlayerNames() {
        playerXName = JOptionPane.showInputDialog(this, "Nhập tên người chơi X:", "Nhập Tên", JOptionPane.PLAIN_MESSAGE);
        if (playerXName == null || playerXName.trim().isEmpty()) {
            playerXName = "Người Chơi X";
        }

        playerOName = JOptionPane.showInputDialog(this, "Nhập tên người chơi O:", "Nhập Tên", JOptionPane.PLAIN_MESSAGE);
        if (playerOName == null || playerOName.trim().isEmpty()) {
            playerOName = "Người Chơi O";
        }
    }

    private void switchPlayer() {
        playerLabel.setText("Người Chơi: " + (count % 2 == 0 ? playerXName : playerOName));
    }

    public boolean checkWin(int i, int j) {
        // Logic kiểm tra thắng thua
        // ...
        String player = b[i][j].getText();
        if (player.equals(" ")) {
            return false; // Không kiểm tra nếu ô trống
        }

        // Kiểm tra hàng ngang
        int count = 0;
        for (int x = 1; x <= column; x++) {
            if (b[x][j].getText().equals(player)) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Kiểm tra hàng dọc
        count = 0;
        for (int y = 1; y <= row; y++) {
            if (b[i][y].getText().equals(player)) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Kiểm tra đường chéo xuôi
        count = 0;
        int startCol = Math.max(1, i - j + 1);
        int startRow = Math.max(1, j - i + 1);
        while (startCol <= column && startRow <= row) {
            if (b[startCol][startRow].getText().equals(player)) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
            startCol++;
            startRow++;
        }

        // Kiểm tra đường chéo ngược
        count = 0;
        startCol = Math.min(column, i + j - 1);
        startRow = Math.max(1, j - (column - i));
        while (startCol >= 1 && startRow <= row) {
            if (b[startCol][startRow].getText().equals(player)) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
            startCol--;
            startRow++;
        }
        return false;
    }

    public void undo() {
        // Logic undo
        // ...
        if (Size > 0) {
            Size--;
            int i = xUndo[Size];
            int j = yUndo[Size];

            b[i][j].setText(" ");
            b[i][j].setBackground(background_cl);
            tick[i][j] = true;
            count = 1 - count;

            if (count % 2 == 0) {
                lb.setText("Lượt Của X");
            } else {
                lb.setText("Lượt Của O");
            }

            if (Size == 0) {
                undo_bt.setEnabled(false);
            }
        }
    }

    public void updatePlayerColors() {
        // Update the colors for "X" and "O" based on the current player
        x_cl = (count % 2 == 0) ? Color.red : Color.red;
        o_cl = (count % 2 == 0) ? Color.blue : Color.blue;

        // Update the color for the winning message
        lb.setBackground((count % 2 == 0) ? x_cl : o_cl);

        // Update the color of the player label
        playerLabel.setForeground((count % 2 == 0) ? x_cl : o_cl);

        // Update the color of the buttons (if needed)
        for (int i = 1; i <= column; i++) {
            for (int j = 1; j <= row; j++) {
                if (b[i][j].getText().equals("X")) {
                    b[i][j].setBackground(x_cl);
                } else if (b[i][j].getText().equals("O")) {
                    b[i][j].setBackground(o_cl);
                }
            }
        }
    }

    public void addPoint(int i, int j) {
        // Logic thêm nước đi và kiểm tra chiến thắng
        String currentPlayer = (count % 2 == 0) ? "X" : "O";
        String currentPlayerName = (count % 2 == 0) ? playerXName : playerOName;

        b[i][j].setText(currentPlayer);
        b[i][j].setBackground((count % 2 == 0) ? x_cl : o_cl);
        tick[i][j] = false;

        // Lưu trữ thông tin nước đi
        xUndo[Size] = i;
        yUndo[Size] = j;
        Size++;

        // Kiểm tra điều kiện chiến thắng
        if (checkWin(i, j)) {
            winner = currentPlayerName;
            lb.setText(currentPlayerName + " WIN");
            for (int x = 1; x <= column; x++) {
                for (int y = 1; y <= row; y++) {
                    b[x][y].setEnabled(false);
                }
            }
            undo_bt.setEnabled(false);
            switchPlayer(); // Bạn có thể bỏ dòng này nếu không muốn hiển thị lượt của người chiến thắng
        } else {
            // Thay đổi lượt chơi
            count = 1 - count;
            lb.setText(count % 2 == 0 ? playerXName + " Đánh" : playerOName + " Đánh");
            undo_bt.setEnabled(true);

            // Nếu đang chơi với máy và không có chiến thắng, máy thực hiện nước đi
            if (isVsComputer && count % 2 != 0) { // Giả sử máy đánh ở lượt "O"
                computerMove();
            }
            switchPlayer();
            updatePlayerColors();
        }
    }

    private void computerMove() {
        // Giả sử máy chọn ô gần nước đi cuối cùng của người chơi
        int lastX = xUndo[Size - 1];
        int lastY = yUndo[Size - 1];

        // Xác định phạm vi để máy thực hiện nước đi
        int range = 1; // Máy sẽ tìm ô trống trong phạm vi 2 ô xung quanh nước đi cuối
        int attempts = 0;

        while (true) {
            int i = lastX + (int) (Math.random() * (2 * range + 1)) - range;
            int j = lastY + (int) (Math.random() * (2 * range + 1)) - range;

            // Kiểm tra nếu vị trí nằm trong bảng và ô đó trống
            if (i > 0 && i <= column && j > 0 && j <= row && tick[i][j]) {
                addPoint(i, j);
                break;
            }

            if (++attempts > 50) {
                // Sau một số lần thử, mở rộng phạm vi hoặc chuyển sang logic khác
                range++;
                if (range > 3) {
                    // Logic dự phòng nếu không tìm thấy ô trong phạm vi gần
                    randomMove();
                    break;
                }
            }
        }
    }

    private void randomMove() {
        // Logic chọn ô ngẫu nhiên nếu không tìm thấy ô trong phạm vi gần
        int attempts = 0;
        while (true) {
            int i = (int) (Math.random() * column) + 1;
            int j = (int) (Math.random() * row) + 1;
            if (tick[i][j]) {
                addPoint(i, j);
                break;
            }
            if (++attempts > column * row) {
                break; // Tránh lặp vô hạn
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == switchMode_cb) {
            isVsComputer = switchMode_cb.isSelected();
            updateModeButton();
        } else if (e.getActionCommand().equals("New Game")) {
            try {
                new CaRo("CODELEARN - GAME DEMO");
                this.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Undo")) {
            undo();
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        } else {
            String s = e.getActionCommand();
            int k = s.indexOf(32);
            int i = Integer.parseInt(s.substring(0, k));
            int j = Integer.parseInt(s.substring(k + 1, s.length()));
            if (tick[i][j]) {
                addPoint(i, j);
            }
            if (checkWin(i, j)) {
                lb.setBackground(Color.MAGENTA);
                lb.setText(winner + " WIN");
                for (i = 1; i <= column; i++) {
                    for (j = 1; j <= row; j++) {
                        b[i][j].setEnabled(false);
                    }
                }
                undo_bt.setEnabled(false);
                newGame_bt.setBackground(Color.YELLOW);
            }
        }
    }

    private void resetGame() {
        // Làm trống bảng cờ
        for (int i = 1; i <= column; i++) {
            for (int j = 1; j <= row; j++) {
                b[i][j].setText(" ");
                b[i][j].setBackground(background_cl);
                tick[i][j] = true;
            }
            winner = null;
        }

        // Thiết lập lại các biến trạng thái trò chơi
        count = 0;
        Size = 0;
        lb.setText(playerXName + " Đánh Trước");
        undo_bt.setEnabled(false);
        newGame_bt.setEnabled(true);

        // Nếu chế độ chơi với máy được chọn, cho phép máy thực hiện nước đi đầu tiên
        if (isVsComputer) {
            computerMove();
        }
    }

    private void updateModeButton() {
        if (isVsComputer) {
            switchMode_cb.setText("Play vs Computer");
        } else {
            switchMode_cb.setText("Play vs Human");
        }
    }

    public static void main(String[] args) {
        new CaRo("GAME CARO");
    }
}
