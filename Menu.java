// package com.mycompany._prog1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;

public class Menu extends JFrame 
{

  private JLabel titleLabel;
  private JButton quickFightButton;
  private JComboBox<String> careerModeComboBox;
  private JLabel imageLabel;

  public Menu() 
  {
    initComponents();
  }

  private void initComponents()
   {
    // Initialize the label and buttons
    titleLabel = new JLabel("Ultimate Fight Master", JLabel.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
    titleLabel.setForeground(Color.WHITE);

    quickFightButton = new JButton("Quick Fight");

    // Create a combo box for Career Mode with options
    careerModeComboBox = new JComboBox<>(new String[] {"Career Mode", "New", "Load"});
    careerModeComboBox.setPreferredSize(new Dimension(150, 30));
    careerModeComboBox.addActionListener(evt -> careerModeComboBoxActionPerformed());

    // Set preferred size for the quick fight button
    quickFightButton.setPreferredSize(new Dimension(100, 30));

    // Add action listeners to buttons
    quickFightButton.addActionListener(evt -> quickFightButtonActionPerformed());

    // Create a panel for the title and buttons
    JPanel topPanel = new JPanel();
    topPanel.setOpaque(false);
    topPanel.setLayout(new BorderLayout());

    JPanel buttonPanel = new JPanel();
    buttonPanel.setOpaque(false);
    buttonPanel.add(quickFightButton);
    buttonPanel.add(careerModeComboBox);  // Add Career Mode combo box to panel

    topPanel.add(titleLabel, BorderLayout.NORTH);
    topPanel.add(buttonPanel, BorderLayout.CENTER);

    // Load and scale the image to the screen size
    ImageIcon imageIcon = new ImageIcon("/Users/reecemilligan/Desktop/Turn-Based-UFC-Game-CS_321-Group-10-/GuiResources/mainmenu.png");
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
    JButton exitButton = new JButton() 
    {
      @Override
      protected void paintComponent(Graphics g) 
      {
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
    exitButton.addActionListener(e -> System.exit(0));

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

    this.addKeyListener(new KeyAdapter()
     {
      @Override
      public void keyPressed(KeyEvent e)
       {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) 
        {
          System.exit(0);
        }
      }
    });

    this.setFocusable(true);
    this.requestFocusInWindow();
    setVisible(true);
  }

  private int getScreenWidth() 
  {
    return this.getToolkit().getDefaultToolkit().getScreenSize().width;
  }

  private int getScreenHeight() 
  {
    return this.getToolkit().getDefaultToolkit().getScreenSize().height;
  }

  private void quickFightButtonActionPerformed() 
  {
    System.out.println("Quick Fight button clicked");
  }

  private void careerModeComboBoxActionPerformed() 
  {
    String selection = (String) careerModeComboBox.getSelectedItem();
    if ("New".equals(selection)) {
      System.out.println("Opening Character Creation...");
      // Open Character_Creation.java (replace this line with actual logic)
      new Character_Creation().setVisible(true);
    } else if ("Load".equals(selection))
     {
      System.out.println("Load game selected");
      // Add load game functionality here
    }
    careerModeComboBox.setSelectedIndex(0); // Reset to default option
  }

  public static void main(String[] args)
  {
    java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
  }
}

