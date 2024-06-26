import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class exerc01 extends JFrame{
    JLabel rotulo1, rotulo2, rotulo3, rotulo4, rotulo5, desenvolvedor;
    JTextField nome, idade;
    JRadioButton masc, fem;
    ButtonGroup sexo;
    JCheckBox automoveis, barcos, avioes;
    String estadocivil[] = {"Solteiro(a)", "Casado(a)"};
    JComboBox combobox;
    JButton limpar, enviar;
    
    public exerc01() {
        super("Formulário");
        Container tela = getContentPane();
        setLayout(null);
        
        // Icon
        ImageIcon icone = new ImageIcon("formulario.png");
        setIconImage(icone.getImage());
        
        rotulo1 = new JLabel("Nome: ");rotulo2 = new JLabel("Idade:");
        rotulo3 = new JLabel("Sexo: "); rotulo4 = new JLabel("Interesses: ");
        rotulo5 = new JLabel("Estado Civil: ");
        desenvolvedor = new JLabel("Desenvolvido por Amanda - 2ºDS-AMS");
        desenvolvedor.setFont(new Font("Courier New",Font.BOLD,14));
        
        nome = new JTextField(50);
        idade = new JTextField(50);

        masc = new JRadioButton("Masculino");
        fem = new JRadioButton("Feminino");
        sexo = new ButtonGroup();
        sexo.add(masc); sexo.add(fem);
        
        masc.setActionCommand("Masculino");
        fem.setActionCommand("Feminino");
        
        automoveis = new JCheckBox("Automóveis");
        barcos = new JCheckBox("Barcos");
        avioes = new JCheckBox("Aviões");
        
        combobox = new JComboBox(estadocivil);
        combobox.setMaximumRowCount(3);
        
        limpar = new JButton("Limpar os dados");
        enviar = new JButton("Enviar os dados");
        
        rotulo1.setBounds(50,20,50,20); rotulo2.setBounds(50,45,50,20);
        rotulo3.setBounds(50,70,50,20); rotulo4.setBounds(50,95,100,20);
        rotulo5.setBounds(50,195,200,20); desenvolvedor.setBounds(50,275,500,20);
        
        nome.setBounds(90,20,200,20);
        idade.setBounds(90,45,100,20);
        
        masc.setBounds(90,70,100,20);
        fem.setBounds(190,70,100,20);
        
        automoveis.setBounds(50,115,200,20);
        barcos.setBounds(50,140,200,20);
        avioes.setBounds(50,165,200,20);
        
        combobox.setBounds(125,195,100,20);
        limpar.setBounds(50,230,150,20);
        enviar.setBounds(210,230,150,20);
        
        nome.setToolTipText("Insira seu nome completo");
        idade.setToolTipText("Insira sua idade atual");
        limpar.setToolTipText("Aperte ALT + L para executar este botão");
        enviar.setToolTipText("Aperte ALT + E para executar este botão");
        
        limpar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int option;
                    Object[] botoes = { "Sim", "Não" };
                    option = JOptionPane.showOptionDialog(null, "Deseja mesmo limpar todos os dados?", "Limpar os dados", 
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, botoes, botoes[0]);
                    
                    if(option == JOptionPane.YES_OPTION)
                    {
                        nome.setText(null);
                        idade.setText(null);
                        
                        sexo.clearSelection();
                        automoveis.setSelected(false);
                        barcos.setSelected(false);
                        avioes.setSelected(false);
                        
                        combobox.setSelectedIndex(0);
                        nome.requestFocus();
                    }
                }
            }
        );
        enviar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String valorcheckbox = "";
                     
                    if (automoveis.isSelected()){
                        valorcheckbox = valorcheckbox + "Automóveis, ";
                    }
                    if (barcos.isSelected()){
                        valorcheckbox = valorcheckbox + "Barcos, ";
                    }
                    if (avioes.isSelected()){
                        valorcheckbox = valorcheckbox + "Aviões";
                    }
                    
                    JOptionPane.showMessageDialog(null, "Dados enviados com sucesso!", "Enviar os dados", JOptionPane.INFORMATION_MESSAGE, null);
                    JOptionPane.showMessageDialog(null,
                            rotulo1.getText() + nome.getText() + "\n" + 
                            rotulo2.getText() + " " + idade.getText() + "\n" + 
                            rotulo3.getText() + sexo.getSelection().getActionCommand() + "\n" + 
                            rotulo4.getText() + valorcheckbox + "\n" + 
                            rotulo5.getText() + combobox.getSelectedItem().toString(),
                            "Informações", JOptionPane.PLAIN_MESSAGE, null);
                }
            }
        );
        
        // Adicionando na tela
        tela.add(rotulo1); tela.add(rotulo2);
        tela.add(rotulo3); tela.add(rotulo4);
        tela.add(rotulo5); tela.add(desenvolvedor);
        
        tela.add(nome);
        tela.add(idade);
        
        tela.add(masc); 
        tela.add(fem);
        
        tela.add(automoveis);
        tela.add(barcos);
        tela.add(avioes);
        
        tela.add(combobox);
        tela.add(limpar);
        tela.add(enviar);
        
        // Atalhos
        getRootPane().setDefaultButton(limpar);
        limpar.setMnemonic(KeyEvent.VK_L); 
        enviar.setMnemonic(KeyEvent.VK_E); 
        
        setSize(500,350);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        exerc01 app = new exerc01();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
    