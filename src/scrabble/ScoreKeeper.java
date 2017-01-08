package scrabble;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class ScoreKeeper extends javax.swing.JFrame {

    /**
     * Creates new form ScrabbleScore
     * make sure word cant go on top
     */
    public ScoreKeeper() {
        initComponents();
        engine.initDictionary("ospd.txt");
        engine.findMatch("dlnpisi");
  //      engine.enterWord("amused", 7, 7, false);
   //     engine.computeBestMatchForOne("amusede", 7, 7, true, 0);        
 /*       engine.enterWord("imbark", 7, 2, true);
        engine.enterWord("meows", 7, 3, false);
        engine.enterWord("vawntie", 10, 1, true);
        engine.enterWord("beeper", 9, 7, false);
        engine.enterWord("lovats", 8, 1, false);
        engine.enterWord("qoph", 12, 5, true);
        engine.enterWord("boxed", 9, 7, true);
 */       display.setText(engine.printBoard());
      //  System.out.println(engine.isValid("vio", 10, 1, false));
     //   System.out.println(engine.isValid("buttals", 9, 7, false));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        wordField1 = new javax.swing.JTextField();
        player1 = new javax.swing.JLabel();
        addButton1 = new javax.swing.JButton();
        scoreField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        player2 = new javax.swing.JLabel();
        player3 = new javax.swing.JLabel();
        player4 = new javax.swing.JLabel();
        addButton2 = new javax.swing.JButton();
        addButton3 = new javax.swing.JButton();
        addButton4 = new javax.swing.JButton();
        scoreField2 = new javax.swing.JTextField();
        scoreField3 = new javax.swing.JTextField();
        scoreField4 = new javax.swing.JTextField();
        rowField = new javax.swing.JTextField();
        columnField = new javax.swing.JTextField();
        horizontalBox = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        wordField1.setToolTipText("");
        wordField1.setName("wordField1"); // NOI18N
        wordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordField1ActionPerformed(evt);
            }
        });

        player1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        player1.setText("Player 1");

        addButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addButton1.setText("Add");
        addButton1.setName("addButton1"); // NOI18N
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });

        scoreField1.setEditable(false);
        scoreField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        scoreField1.setText("Score");
        scoreField1.setName("scoreField1"); // NOI18N
        scoreField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Enter your words to find the total score");

        player2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        player2.setText("Player 3");

        player3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        player3.setText("Player 2");

        player4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        player4.setText("Player 4");

        addButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addButton2.setText("Add");
        addButton2.setName("addButton1"); // NOI18N
        addButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton2ActionPerformed(evt);
            }
        });

        addButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addButton3.setText("Add");
        addButton3.setName("addButton1"); // NOI18N
        addButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton3ActionPerformed(evt);
            }
        });

        addButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addButton4.setText("Add");
        addButton4.setName("addButton1"); // NOI18N
        addButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton4ActionPerformed(evt);
            }
        });

        scoreField2.setEditable(false);
        scoreField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        scoreField2.setText("Score");
        scoreField2.setName("scoreField1"); // NOI18N
        scoreField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreField2ActionPerformed(evt);
            }
        });

        scoreField3.setEditable(false);
        scoreField3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        scoreField3.setText("Score");
        scoreField3.setName("scoreField1"); // NOI18N
        scoreField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreField3ActionPerformed(evt);
            }
        });

        scoreField4.setEditable(false);
        scoreField4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        scoreField4.setText("Score");
        scoreField4.setName("scoreField1"); // NOI18N
        scoreField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreField4ActionPerformed(evt);
            }
        });

        rowField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowFieldActionPerformed(evt);
            }
        });

        horizontalBox.setText("Horizontal");
        horizontalBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horizontalBoxActionPerformed(evt);
            }
        });

        jButton1.setText("Find Best Word");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("Letters");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter letters to find your best word");

        display.setColumns(20);
        display.setRows(5);
        display.setName("display"); // NOI18N
        jScrollPane1.setViewportView(display);

        jLabel3.setText("Row");

        jLabel4.setText("Column");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setText("Check");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Check if your word is in the Dictionary");

        jButton3.setText("Load Game");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(wordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rowField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(horizontalBox))
                                    .addComponent(columnField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2)
                                        .addGap(30, 30, 30)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 124, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(player4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(scoreField1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addButton4)
                                        .addGap(18, 18, 18)
                                        .addComponent(scoreField4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(scoreField3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(scoreField2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel1))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25)
                        .addComponent(wordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(horizontalBox)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(columnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton1)
                            .addComponent(scoreField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton2)
                            .addComponent(scoreField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton3)
                            .addComponent(scoreField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton4)
                            .addComponent(scoreField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordField1ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_wordField1ActionPerformed
    private void addButtonActionPerformed(ScoreCalculator calculator, javax.swing.JTextField scoreField){
        String word = wordField1.getText().toLowerCase();
        wordField1.setText("");
        wordField1.requestFocus();
        //int score = calculator[0].calculate(word, selected);
        String row = rowField.getText();
        String column = columnField.getText();
        if (row.isEmpty()){
            System.out.println("Enter something in row.");
            return;
        }
        if (column.isEmpty()){
            System.out.println("Enter something in column.");
            return;
        }
        if (word.isEmpty()){
            System.out.println("Enter something in Word.");
            return;
        }
        if (!engine.checkWord(word)){
            System.out.println("Enter valid word.");
            return;
        }
        int rowInt = Integer.parseInt(row);
        int columnInt = Integer.parseInt(column);
        System.out.println("Row = "+row+", column = "+column+". Horizontal = "+horizontalBox.isSelected()+".");
        int score1 = engine.isValid(word, rowInt, columnInt, horizontalBox.isSelected());
        if (score1 == -1){
            System.out.println("Word is invalid.");
            return;
        }
        calculator.addExtraScore(score1);
        int score = engine.computeScore(word, rowInt, columnInt, horizontalBox.isSelected(), calculator);
        scoreField.setText(""+score);
        engine.enterWord(word, rowInt, columnInt, horizontalBox.isSelected(), score, true);
        display.setText(engine.printBoard());
    }
    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        // TODO add your handling code here:
        addButtonActionPerformed(calculator[0], scoreField1);
    }//GEN-LAST:event_addButton1ActionPerformed

    private void scoreField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreField1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_scoreField1ActionPerformed

    private void addButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton2ActionPerformed
        // TODO add your handling code here:
        addButtonActionPerformed(calculator[1], scoreField2);
    }//GEN-LAST:event_addButton2ActionPerformed

    private void addButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton3ActionPerformed
        // TODO add your handling code here:
        addButtonActionPerformed(calculator[2], scoreField3);
    }//GEN-LAST:event_addButton3ActionPerformed

    private void addButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton4ActionPerformed
        // TODO add your handling code here:
        addButtonActionPerformed(calculator[3], scoreField4);
    }//GEN-LAST:event_addButton4ActionPerformed

    private void scoreField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoreField2ActionPerformed

    private void scoreField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoreField3ActionPerformed

    private void scoreField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoreField4ActionPerformed

    private void rowFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rowFieldActionPerformed

    private void horizontalBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horizontalBoxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_horizontalBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BestResult result = engine.findBestMatch(jTextField1.getText());
        wordField1.setText(result.word);
        rowField.setText(""+result.row);
        columnField.setText(""+result.column);
        horizontalBox.setSelected(result.horizontal);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String word = jTextField2.getText().toLowerCase();
        if (engine.checkWord(word) == true){
            jTextField3.setText("Yes");
        }
        else {
            jTextField3.setText("No");
        }    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        engine.reloadGame();
        display.setText(engine.printBoard());
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScoreKeeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreKeeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreKeeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreKeeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreKeeper().setVisible(true);
            }
        });
    }
    ScrabbleEngine engine = new ScrabbleEngine();
    private ScoreCalculator []calculator = new ScoreCalculator[4]; 
    
    {
        for (int i = 0; i<4; i++){
            calculator[i] = new ScoreCalculator();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton1;
    private javax.swing.JButton addButton2;
    private javax.swing.JButton addButton3;
    private javax.swing.JButton addButton4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField columnField;
    private javax.swing.JTextArea display;
    private javax.swing.JCheckBox horizontalBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JLabel player3;
    private javax.swing.JLabel player4;
    private javax.swing.JTextField rowField;
    private javax.swing.JTextField scoreField1;
    private javax.swing.JTextField scoreField2;
    private javax.swing.JTextField scoreField3;
    private javax.swing.JTextField scoreField4;
    private javax.swing.JTextField wordField1;
    // End of variables declaration//GEN-END:variables
}
