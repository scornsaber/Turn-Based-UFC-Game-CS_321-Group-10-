/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//package com.mycompany._prog1;

/**
 *
 * @author scorn
 */

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
 
 public class Character_Creation extends JFrame {
 
     private JLabel remainingPointsLabel;
     private int remainingPoints = 20;
     private JLabel[] attributeLabels;
     private int[] attributePoints = new int[7]; // Points for F, I, G, H, T, E, R
 
     public Character_Creation()
      {
         initComponents();
     }
 
     private void initComponents()
      {
         // Set up JFrame for full-screen
         setTitle("Character Creation");
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         setUndecorated(true);
         setLayout(new BorderLayout());
 
         // Sidebar Panel for Points Allocation
         JPanel sidebarPanel = new JPanel();
         sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
         sidebarPanel.setBackground(Color.DARK_GRAY);
         sidebarPanel.setPreferredSize(new Dimension(250, getScreenHeight() - 40)); // Fixed width for sidebar
 
         // Remaining points label
         remainingPointsLabel = new JLabel("Remaining Points: " + remainingPoints);
         remainingPointsLabel.setForeground(Color.WHITE);
         remainingPointsLabel.setFont(new Font("Arial", Font.BOLD, 14));
         remainingPointsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
         sidebarPanel.add(remainingPointsLabel);
 
         // Attributes list - vertically aligned
         String[] attributes = {"Force", "Intelligence", "Grit", "Hold", "Technique", "Execution", "Resilience"};
         attributeLabels = new JLabel[attributes.length];
 
         JPanel attributesPanel = new JPanel();
         attributesPanel.setLayout(new BoxLayout(attributesPanel, BoxLayout.Y_AXIS));
         attributesPanel.setBackground(Color.BLACK);
 
         for (int i = 0; i < attributes.length; i++) {
             JPanel attributePanel = new JPanel();
             attributePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0)); // Small horizontal gap
             attributePanel.setBackground(Color.WHITE);
 
             JLabel attributeLabel = new JLabel(attributes[i] + ": ");
             attributeLabel.setForeground(Color.BLACK);
             attributeLabel.setFont(new Font("Arial", Font.BOLD, 14));
             attributePanel.add(attributeLabel);
 
             // < label to decrease attribute
             JLabel decreaseLabel = new JLabel("<");
             decreaseLabel.setForeground(Color.BLACK);
             decreaseLabel.setFont(new Font("Arial", Font.BOLD, 14));
             int index = i;
             decreaseLabel.addMouseListener(new MouseAdapter() 
             {
                 @Override
                 public void mouseClicked(MouseEvent e) {
                     if (remainingPoints < 20 && attributePoints[index] > 0) {
                         remainingPoints++;
                         attributePoints[index]--;
                         updateAttributeDisplay(index);
                     }
                 }
             });
             attributePanel.add(decreaseLabel);
 
             // Display current points for the attribute in the center
             attributeLabels[i] = new JLabel(String.valueOf(attributePoints[i]));
             attributeLabels[i].setForeground(Color.BLACK);
             attributeLabels[i].setFont(new Font("Arial", Font.BOLD, 14));
             attributePanel.add(attributeLabels[i]);
 
             // > label to increase attribute
             JLabel increaseLabel = new JLabel(">");
             increaseLabel.setForeground(Color.BLACK);
             increaseLabel.setFont(new Font("Arial", Font.BOLD, 14));
             increaseLabel.addMouseListener(new MouseAdapter() 
             {
                 @Override
                 public void mouseClicked(MouseEvent e) {
                     if (remainingPoints > 0) {
                         remainingPoints--;
                         attributePoints[index]++;
                         updateAttributeDisplay(index);
                     }
                 }
             });
             attributePanel.add(increaseLabel);
 
             attributesPanel.add(attributePanel);
         }
 
         sidebarPanel.add(attributesPanel);
 
         // Reset button
         JButton resetButton = new JButton("Reset Points");
         resetButton.setFont(new Font("Arial", Font.BOLD, 18));
         resetButton.setBackground(Color.BLACK);
         resetButton.setForeground(Color.BLACK);
         resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
         resetButton.addActionListener(e -> resetPoints());
         sidebarPanel.add(Box.createVerticalStrut(20));
         sidebarPanel.add(resetButton);
 
         this.add(sidebarPanel, BorderLayout.WEST);
 
         // Right-side panel for country dropdown, image frame, name field, color buttons, and save button
         JPanel rightPanel = new JPanel(new GridBagLayout());
         rightPanel.setBackground(Color.LIGHT_GRAY);
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.fill = GridBagConstraints.BOTH;
         gbc.insets = new Insets(10, 10, 10, 10);
         gbc.weightx = 1.0;
 
         // Country selection dropdown
         String[] countries = {"Country of Origin", "Brazil", "China", "Japan", "Mexico", "Netherlands", "Nigeria", "North Korea", "Russia", "USA"};
         JComboBox<String> countryDropdown = new JComboBox<>(countries);
         gbc.gridx = 0;
         gbc.gridy = 0;
         gbc.weighty = 0.1;
         rightPanel.add(countryDropdown, gbc);
 
         // Image frame placeholder
         JPanel imageFrame = new JPanel();
         imageFrame.setBackground(Color.DARK_GRAY);
         gbc.gridy = 1;
         gbc.weighty = 0.5;
         imageFrame.setPreferredSize(new Dimension(200, 200));
         rightPanel.add(imageFrame, gbc);
 
         // Fighter Name label and input field panel
         JPanel namePanel = new JPanel();
         namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
         namePanel.setBackground(Color.LIGHT_GRAY);
 
         JLabel nameLabel = new JLabel("Fighter Name:");
         nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
         nameLabel.setForeground(Color.BLACK);
 
         JTextField nameField = new JTextField(15);
         nameField.setPreferredSize(new Dimension(150, 25));
 
         namePanel.add(nameLabel);
         namePanel.add(nameField);
 
         gbc.gridy = 2;
         gbc.weighty = 0.1;
         rightPanel.add(namePanel, gbc);
 
         // Pants color selection buttons
         JPanel colorPanel = new JPanel();
         colorPanel.setLayout(new GridLayout(1, 6, 5, 5));
         gbc.gridy = 3;
         gbc.weighty = 0.1;
         Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
         for (Color color : colors) {
             JButton colorButton = new JButton();
             colorButton.setBackground(color);
             colorButton.setOpaque(true);
             colorButton.setBorderPainted(false);
             colorPanel.add(colorButton);
         }
         rightPanel.add(colorPanel, gbc);
 
         // Save Fighter button
         JButton saveButton = new JButton("Save Fighter");
         saveButton.setFont(new Font("Arial", Font.BOLD, 16));
         saveButton.setBackground(Color.GREEN);
         saveButton.setForeground(Color.BLACK);
         gbc.gridy = 4;
         gbc.weighty = 0.1;
         rightPanel.add(saveButton, gbc);
 
         this.add(rightPanel, BorderLayout.CENTER);
 
         // Exit button
         JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
         exitPanel.setOpaque(false);
 
         JButton exitButton = new JButton() {
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
         exitPanel.add(exitButton);
 
         this.add(exitPanel, BorderLayout.NORTH);
 
         setFocusable(true);
         requestFocusInWindow();
         setVisible(true);
     }
 
     private void updateAttributeDisplay(int index) 
     {
         attributeLabels[index].setText(String.valueOf(attributePoints[index]));
         remainingPointsLabel.setText("Remaining Points: " + remainingPoints);
     }
 
     private void resetPoints() 
     {
         remainingPoints = 20;
         for (int i = 0; i < attributePoints.length; i++)
          {
             attributePoints[i] = 0;
             attributeLabels[i].setText("0");
         }
         remainingPointsLabel.setText("Remaining Points: " + remainingPoints);
     }
 
     private int getScreenHeight() {
         return this.getToolkit().getScreenSize().height;
     }
 
     public static void main(String[] args) 
     {
         java.awt.EventQueue.invokeLater(Character_Creation::new);
     }
 }
 
 
 
 
 
 
 








