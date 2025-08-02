-- Insert compatibility label entries
INSERT INTO compatibility_label (match_type, title, description) 
VALUES ('Natural', 'Sunny', 'Represents positive energy. Schedule important things in your life such as signing contracts, getting married, going on an importatnt meeting, having surgery, etc.' );

INSERT INTO compatibility_label (match_type, title, description) 
VALUES ('Compatible', 'Cloudy', 'Good day to do simple things like get together with friends, pay bills, run errands, etc. There is some duality in the numbers, it is not best to schedule major thinkgs where you are counting on others to make it go smoothly for you.' );

INSERT INTO compatibility_label (match_type, title, description) 
VALUES ('Challenge', 'Caution', 'Stay focused and do not let the little things get to you. Dont schedule something on this day intentionally. If you do have something important scheduled, maintain the right attitude to still make it a productive day.');

-- Insert compatibility matrix entries
-- Lifepath 1
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (1, 1, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (1, 2, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (1, 3, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (1, 4, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (1, 5, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (1, 6, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (1, 7, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (1, 8, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (1, 9, 2);
-- Lifepath 2
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (2, 1, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (2, 2, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (2, 3, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (2, 4, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (2, 5, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (2, 6, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (2, 7, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (2, 8, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (2, 9, 2);
-- Lifepath 3
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (3, 1, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (3, 2, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (3, 3, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (3, 4, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (3, 5, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (3, 6, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (3, 7, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (3, 8, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (3, 9, 1);
-- Lifepath 4
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (4, 1, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (4, 2, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (4, 3, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (4, 4, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (4, 5, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (4, 6, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (4, 7, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (4, 8, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (4, 9, 3);
-- Lifepath 5
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (5, 1, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (5, 2, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (5, 3, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (5, 4, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (5, 5, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (5, 6, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (5, 7, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (5, 8, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (5, 9, 2);
-- Lifepath 6
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (6, 1, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (6, 2, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (6, 3, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (6, 4, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (6, 5, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (6, 6, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (6, 7, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (6, 8, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (6, 9, 1);
-- Lifepath 7
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (7, 1, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (7, 2, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (7, 3, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (7, 4, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (7, 5, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (7, 6, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (7, 7, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (7, 8, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (7, 9, 3);
-- Lifepath 8
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (8, 1, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (8, 2, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (8, 3, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (8, 4, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (8, 5, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (8, 6, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (8, 7, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (8, 8, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (8, 9, 3);
-- Lifepath 9
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (9, 1, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (9, 2, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (9, 3, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (9, 4, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (9, 5, 2);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (9, 6, 1);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (9, 7, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (9, 8, 3);
INSERT INTO compatibility_matrix (lifepath_number, calendar_day_number, label_id) VALUES (9, 9, 1);