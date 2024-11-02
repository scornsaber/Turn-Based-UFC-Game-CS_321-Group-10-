/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._prog1;

/**
 * Menu
 * Player_Menu: New game, load game, or player vs player
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;

public class Menu extends JFrame {

  private JLabel titleLabel;
  private JButton newLoadButton;
  private JButton quickFightButton;
  private JLabel imageLabel;

  public Menu() {
    initComponents();
  }

  private void initComponents() {
    // Initialize the label and buttons
    titleLabel = new JLabel("Ultimate Fight Master", JLabel.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
    titleLabel.setForeground(Color.WHITE);

    newLoadButton = new JButton("New/Load");
    quickFightButton = new JButton("Quick Fight");

    // Set preferred size for the buttons
    newLoadButton.setPreferredSize(new Dimension(100, 30));
    quickFightButton.setPreferredSize(new Dimension(100, 30));

    // Add action listeners to buttons
    newLoadButton.addActionListener(evt -> newLoadButtonActionPerformed());
    quickFightButton.addActionListener(evt -> quickFightButtonActionPerformed());

    // Create a panel for the title and buttons
    JPanel topPanel = new JPanel();
    topPanel.setOpaque(false);
    topPanel.setLayout(new BorderLayout());

    JPanel buttonPanel = new JPanel();
    buttonPanel.setOpaque(false);
    buttonPanel.add(newLoadButton);
    buttonPanel.add(quickFightButton);

    topPanel.add(titleLabel, BorderLayout.NORTH);
    topPanel.add(buttonPanel, BorderLayout.CENTER);

    // Load and scale the image to the screen size
    ImageIcon imageIcon = new ImageIcon("/Users/reecemilligan/Desktop/mainmenu.png");
    Image image = imageIcon.getImage().getScaledInstance(getScreenWidth(), getScreenHeight(), Image.SCALE_SMOOTH);
    imageLabel = new JLabel(new ImageIcon(image));

    // Create a layered pane
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setLayout(null);

    imageLabel.setBounds(0, 0, getScreenWidth(), getScreenHeight());
    layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

    topPanel.setBounds(0, getScreenHeight() / 4, getScreenWidth(), 200);
    layeredPane.add(topPanel, JLayeredPane.PALETTE_LAYER);

    // Create a custom red exit button
    JButton exitButton = new JButton() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("X", getWidth() / 2 - 4, getHeight() / 2 + 4);
      }
    };

    exitButton.setPreferredSize(new Dimension(15, 15));
    exitButton.setBorder(BorderFactory.createEmptyBorder());
    exitButton.setContentAreaFilled(false);

    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    JPanel controlPanel = new JPanel();
    controlPanel.setOpaque(false);
    controlPanel.setLayout(null);
    controlPanel.setBounds(10, 10, 30, 30);

    exitButton.setBounds(0, 0, 10, 10);
    controlPanel.add(exitButton);

    layeredPane.add(controlPanel, JLayeredPane.PALETTE_LAYER);

    this.setLayout(new BorderLayout());
    this.add(layeredPane, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Main Menu");
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setUndecorated(true);

    this.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
          System.exit(0);
        }
      }
    });

    this.setFocusable(true);
    this.requestFocusInWindow();
    setVisible(true);
  }

  private int getScreenWidth() {
    return this.getToolkit().getDefaultToolkit().getScreenSize().width;
  }

  private int getScreenHeight() {
    return this.getToolkit().getDefaultToolkit().getScreenSize().height;
  }

  private void newLoadButtonActionPerformed() {
    System.out.println("New/Load button clicked");
  }

  private void quickFightButtonActionPerformed() {
    System.out.println("Quick Fight button clicked");
  }

  public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
      new Menu().setVisible(true);
    });
  }
}

