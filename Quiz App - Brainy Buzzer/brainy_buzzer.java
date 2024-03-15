import com.google.gson.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class brainy_buzzer {}

class quiz_app extends brainy_buzzer implements ActionListener {

    String question,correctAnswer, selected_radio_button;
    JFrame frame1 = new JFrame();
    JFrame frame2=new JFrame();
    JFrame frame3=new JFrame();
    JFrame frame4=new JFrame();
    JLabel l,l1, l2, l3, l4, l5, l6, l7,l8, f2l1, f2l2,f2l3,f2l5, name_label_f3,f3l2, question_l2_f3,f4l1,f4l2;
    JRadioButton r1,r2,r3,r4,f2r3,f2r4,f2r5;
    ButtonGroup bg1,bg2;
    int q_no=1, score=0;
    JTextField name_input;
    JButton f1_exit_button, f1_next_button, f2_startquiz_button, f2_previous_button, next_q , get_results, exit_button_f4;
    ImageIcon icon =new ImageIcon("D:\\Java_Project\\untitled\\src\\icon_image.png");
    ImageIcon f1_bg_image=new ImageIcon("D:\\Java_Project\\untitled\\src\\frame1_image.jpg");
    ImageIcon f2_bg_image =new ImageIcon("D:\\Java_Project\\untitled\\src\\frame2_image.png");
    ImageIcon f3_bg_image =new ImageIcon("D:\\Java_Project\\untitled\\src\\frame3_image.jpg");
    ImageIcon f4_bg_image =new ImageIcon("D:\\Java_Project\\untitled\\src\\frame4_image.jpg");
    String name;
    URL api_url;


    //    .......................FRAME 1............................
    void frame1_method() {

//        frame properties
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setContentPane(new JLabel(f1_bg_image));
        frame1.setIconImage(icon.getImage());
        frame1.setTitle("Brainy Buzzer");
        frame1.setLayout(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        frame1.setSize(850, 550);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);

//        elements
        l = new JLabel("Instructions");
        l1 = new JLabel("1. Choose Your Quiz: Select a quiz category from the options provided.");
        l2 = new JLabel("2. Test Your Knowledge: Answer the questions presented to you");
        l3 = new JLabel("within the given time limit.");
        l4 = new JLabel("3. Earn Points: Earn points for each correct answer.");
        l5 = new JLabel("The quicker you answer, the more points you'll earn!");
        l6 = new JLabel("4. Challenge Yourself: Beat your own high score or compete with");
        l7 = new JLabel("friends to see who's the ultimate quiz champion.");
        l8 = new JLabel("5. Learn and Have Fun: Enjoy learning new facts and trivia while");

        l.setForeground(new Color(15, 82, 186));
        Color textColor = Color.BLACK;
        l1.setForeground(textColor);
        l2.setForeground(textColor);
        l3.setForeground(textColor);
        l4.setForeground(textColor);
        l5.setForeground(textColor);
        l6.setForeground(textColor);
        l7.setForeground(textColor);
        l8.setForeground(textColor);

        Font font1 = new Font("Times New Roman",Font.BOLD,24);
        l.setFont(font1);
        Font font = new Font("Times New Roman", Font.PLAIN, 18);
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l6.setFont(font);
        l7.setFont(font);
        l8.setFont(font);

        l.setBounds(10, 10, 300, 40);
        l1.setBounds(10, 50, 800, 30);
        l2.setBounds(10, 90, 800, 30);
        l3.setBounds(10, 130, 800, 30);
        l4.setBounds(10, 170, 800, 30);
        l5.setBounds(10, 210, 800, 30);
        l6.setBounds(10, 250, 800, 30);
        l7.setBounds(10, 290, 800, 30);
        l8.setBounds(10, 330, 800, 30);

        f1_next_button = new JButton("Next");
        f1_next_button.setBounds(230, 400, 80, 50);
        f1_next_button.setBackground(new Color(15, 82, 186));
        f1_next_button.setForeground(Color.WHITE);
        f1_next_button.addActionListener(this);

        f1_exit_button = new JButton("Exit");
        f1_exit_button.setBounds(320, 400, 80, 50);
        f1_exit_button.setBackground(new Color(15, 82, 186));
        f1_exit_button.setForeground(Color.WHITE);
        f1_exit_button.addActionListener(this);

        //add elements inside frame 1
        frame1.add(l);
        frame1.add(l1);
        frame1.add(l2);
        frame1.add(l3);
        frame1.add(l4);
        frame1.add(l5);
        frame1.add(l6);
        frame1.add(l7);
        frame1.add(l8);
        frame1.add(f1_next_button);
        frame1.add(f1_exit_button);

    }
    //    ............................FRAME 2...................................
    void frame2_method() {
        // frame2 properties
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setIconImage(icon.getImage());
        frame2.setTitle("Brainy Buzzer");
        frame2.setLayout(null);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setSize(850, 550);
        frame2.setResizable(false);
        frame2.setLocationRelativeTo(null);

        // frame 2 elements
        f2l3 = new JLabel(f2_bg_image);
        frame2.setContentPane(f2l3);

        JLabel transparent_box = new JLabel();
        transparent_box.setBounds(215, 80, 380, 300);
        transparent_box.setOpaque(true);
        transparent_box.setBackground(new Color(255, 255, 255, 200));
        transparent_box.setLayout(null);

        f2l1 = new JLabel("BRAINY BUZZER");
        Font font2 = new Font("Times New Roman", Font.BOLD, 24);
        f2l1.setFont(font2);
        f2l1.setForeground(new Color(77, 77, 188));
        f2l1.setBounds(120, 10, 200, 50);

        f2l2 = new JLabel("Enter Your Name:");
        f2l2.setBounds(20, 70, 200, 25);

        name_input = new JTextField();
        name_input.setBounds(150, 70, 180, 25);

        f2l5 = new JLabel("Quiz Level:");
        f2l5.setBounds(20, 100, 100, 25);

        f2_startquiz_button = new JButton("Start Quiz");
        f2_startquiz_button.setBounds(20, 220, 150, 40);
        f2_startquiz_button.setBackground(new Color(15, 82, 186));
        f2_startquiz_button.setForeground(Color.WHITE);
        f2_startquiz_button.addActionListener(this);

        f2_previous_button = new JButton("Previous Page");
        f2_previous_button.setBounds(200, 220, 150, 40);
        f2_previous_button.setBackground(new Color(15, 82, 186));
        f2_previous_button.setForeground(Color.WHITE);
        f2_previous_button.addActionListener(this);

        f2r3 = new JRadioButton("Easy");
        f2r3.setBounds(150, 110, 100, 25);

        f2r4 = new JRadioButton("Medium");
        f2r4.setBounds(150, 130, 120, 25);

        f2r5 = new JRadioButton("Hard");
        f2r5.setBounds(150, 150, 100, 25);

        bg1 = new ButtonGroup();
        bg1.add(f2r3);
        bg1.add(f2r4);
        bg1.add(f2r5);

        // Add elements inside transparent box
        transparent_box.add(f2l1);
        transparent_box.add(f2l2);
        transparent_box.add(f2l5);
        transparent_box.add(name_input);
        transparent_box.add(f2_startquiz_button);
        transparent_box.add(f2_previous_button);
        transparent_box.add(f2r3);
        transparent_box.add(f2r4);
        transparent_box.add(f2r5);

        // Add transparent box to frame 2
        frame2.add(transparent_box);
    }


    void delay_function()
    {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        int delayInSeconds = 5;

        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                next_q.setEnabled(true);
            }
        }, delayInSeconds, TimeUnit.SECONDS);

    }


    //    .............................FRAME 3................................
    void frame3_method()
    {


        // frame properties
        frame3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame3.setContentPane(new JLabel(f3_bg_image));
        frame3.setTitle("Brainy Buzzer");
        frame3.setLayout(null);
        frame3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame3.setSize(850, 550);
        frame3.setResizable(false);
        frame3.setLocationRelativeTo(null);
        frame3.setIconImage(icon.getImage());

        // elements
        Font labelFont = new Font("Times New Roman", Font.BOLD, 24);

//        name
        name_label_f3 = new JLabel();
        name_label_f3.setForeground(Color.WHITE);
        name_label_f3.setFont(labelFont);
        name_label_f3.setHorizontalAlignment(SwingConstants.CENTER);
        name_label_f3.setBounds(200, 75, 450, 50);

//        question
        f3l2 = new JLabel();
        f3l2.setForeground(Color.WHITE);
        f3l2.setBounds(120, 150, 850, 50);

//        question label 2
        question_l2_f3 = new JLabel();
        question_l2_f3.setForeground(Color.WHITE);
        question_l2_f3.setBounds(120, 170, 850, 50);

        r1 = new JRadioButton();
        r1.setForeground(Color.white);
        r1.setOpaque(false);
        r1.setBounds(120, 210, 850, 50);

        r2 = new JRadioButton();
        r2.setForeground(Color.white);
        r2.setOpaque(false);
        r2.setBounds(120, 250, 850, 50);

        r3 = new JRadioButton();
        r3.setForeground(Color.white);
        r3.setOpaque(false);
        r3.setBounds(120, 290, 850, 50);

        r4 = new JRadioButton();
        r4.setForeground(Color.white);
        r4.setOpaque(false);
        r4.setBounds(120, 330, 850, 50);

        bg2 = new ButtonGroup();
        bg2.add(r1);
        bg2.add(r2);
        bg2.add(r3);
        bg2.add(r4);



        next_q = new JButton("Next Question");
        next_q.setBounds(300, 382, 200, 50);
        next_q.addActionListener(this);
        next_q.setEnabled(false);

        get_results = new JButton("Get Results");
        get_results.setBounds(300, 382, 200, 50);
        get_results.addActionListener(this);

        // add elements inside frame3
        frame3.add(name_label_f3);
        frame3.add(f3l2);
        frame3.add(question_l2_f3);
        frame3.add(r1);
        frame3.add(r2);
        frame3.add(r3);
        frame3.add(r4);
        frame3.add(next_q);



    }



    //    ...........................................FRAME 4......................................................
    void frame4_method()
    {

        frame4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame4.setContentPane(new JLabel(f4_bg_image));
        frame4.setIconImage(icon.getImage());
        frame4.setTitle("Brainy Buzzer");
        frame4.setLayout(null);
        frame4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame4.setSize(850,550);
        frame4.setLocationRelativeTo(null);
        frame4.setResizable(false);

        f4l1 = new JLabel("Your Score:");
        Font font4 = new Font("Times New Roman",Font.BOLD,55);
        f4l1.setFont(font4);
        f4l1.setForeground(new Color(15,82,186));
        f4l1.setBounds(50, 50, 390, 100);
        f4l2 = new JLabel();
        Font font5 = new Font("Times New Roman",Font.BOLD,80);
        f4l2.setFont(font5);
        f4l2.setForeground(new Color(15,82,186));
        f4l2.setBounds(180, 270, 300, 60);
        exit_button_f4 = new JButton("Exit");
        exit_button_f4.setBounds(320, 450, 90, 50);
        exit_button_f4.setBackground(new Color(15, 82, 186));
        exit_button_f4.setForeground(Color.WHITE);
        exit_button_f4.addActionListener(this);
        frame4.add(f4l1);
        frame4.add(f4l2);
        frame4.add(exit_button_f4);


    }

    void api() {
        delay_function();
        try {


            if (f2r3.isSelected()) {
                api_url = new URL("https://opentdb.com/api.php?amount=1&difficulty=easy&type=multiple");
            } else if (f2r4.isSelected()) {
                api_url = new URL("https://opentdb.com/api.php?amount=1&difficulty=medium&type=multiple");
            } else if (f2r5.isSelected()) {
                api_url = new URL("https://opentdb.com/api.php?amount=1&difficulty=hard&type=multiple");
            }

            HttpURLConnection connection = (HttpURLConnection) api_url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);

            JsonArray questionsArray = jsonResponse.getAsJsonArray("results");

            if (questionsArray.size() > 0) {
                JsonObject questionObject = questionsArray.get(0).getAsJsonObject();
                question = replace(questionObject.get("question").getAsString()) ;
                f3l2.setText(q_no + ". " + question);

                // If the question length exceeds 90 characters, split it into multiple lines
                if (f3l2.getText().length() > 90) {
                    int length = f3l2.getText().length();
                    String remainingText = f3l2.getText().substring(90, length);
                    question_l2_f3.setText(remainingText);
                    f3l2.setText(f3l2.getText().substring(0, 90));
                }

                correctAnswer =replace(questionObject.get("correct_answer").getAsString());
                JsonArray incorrectAnswersArray = questionObject.getAsJsonArray("incorrect_answers");
                ArrayList<String> allAnswers = new ArrayList<>();
                allAnswers.add(correctAnswer);
                for (JsonElement incorrectAnswer : incorrectAnswersArray) {
                    allAnswers.add(replace(incorrectAnswer.getAsString()));
                }
                Collections.shuffle(allAnswers);
                r1.setText(allAnswers.get(0));
                r2.setText(allAnswers.get(1));
                r3.setText(allAnswers.get(2));
                r4.setText(allAnswers.get(3));
            }
        } catch (Exception e) {
            System.out.println("error_catch");
        }
    }
    boolean internet_connection() {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            connection.disconnect();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static String replace(String text)
    {
        return text.replaceAll("&quot;", "\"")
                .replaceAll("&amp;", "&")
                .replaceAll("&#039;", "'")
                .replaceAll("&lt;", "<")
                .replaceAll("&gt;", ">");
    }
    void calculate_score()
    {
        if (r1.isSelected()) {
            selected_radio_button = r1.getText();
        } else if (r2.isSelected()) {
            selected_radio_button = r2.getText();
        } else if (r3.isSelected()) {
            selected_radio_button = r3.getText();
        } else if (r4.isSelected()) {
            selected_radio_button = r4.getText();
        }
        else {
            selected_radio_button="null";
        }
        if (selected_radio_button.equals(correctAnswer))
        {
            score++;

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== f1_exit_button)
        {
            frame1.dispose();
        } else if (e.getSource()== f1_next_button) {
            frame2.setVisible(true);
            frame1.dispose();

        } else if (e.getSource()== f2_previous_button) {
            frame1.setVisible(true);
            frame2.dispose();
        }
        else if(e.getSource()== f2_startquiz_button)
        {
            if (!internet_connection()) {
                JOptionPane.showMessageDialog(frame2, "Please check your internet connection and try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                if (name_input.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame2, "Please Enter Your Name!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!(f2r3.isSelected() || f2r4.isSelected() || f2r5.isSelected())) {
                    JOptionPane.showMessageDialog(frame2, "Please Select Quiz Level!!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    name = name_input.getText();
                    name_label_f3.setText("Hii, " + name);
                    frame3.setVisible(true);
                    frame2.dispose();
                    api();
                }
            }
        }
        else if (e.getSource() == next_q) {
            next_q.setEnabled(false);

            question_l2_f3.setText(null);
            calculate_score();

            bg2.clearSelection();
            q_no++;
            if (q_no==10) {
                frame3.remove(next_q);
                frame3.add(get_results);
            }
            api();
        }
        else if (e.getSource()== get_results)
        {
            calculate_score();
            f4l2.setText(String.valueOf(score));
            frame3.dispose();
            frame4.setVisible(true);
        }

        else if (e.getSource()== exit_button_f4)
        {
            frame4.dispose();
        }

    }

    public static void main(String[] args) {
        quiz_app a = new quiz_app();
        a.frame1_method();
        a.frame2_method();
        a.frame3_method();
        a.frame4_method();
    }
}