package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class StatisticsView extends JFrame {
    private List<StatisticView> statisticViews;

    public StatisticsView(StatisticView... views) {
        this.statisticViews = Arrays.asList(views);
        initializeUI();
    }

    private void initializeUI() {
        setTitle("統計資訊");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        for (StatisticView view : this.statisticViews) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JLabel(view.getClass().getSimpleName()), BorderLayout.NORTH);

            StatisticsData statistics = view.getStatistics();
            if (statistics != null) {
                panel.add(new JTextArea(statistics.toString()), BorderLayout.CENTER);
            } else {
                panel.add(new JLabel("無法獲取統計資訊"), BorderLayout.CENTER);
            }

            tabbedPane.addTab(view.getClass().getSimpleName(), panel);
        }

        add(tabbedPane, BorderLayout.CENTER);
    }

    public void display() {
        setVisible(true);
    }
}



