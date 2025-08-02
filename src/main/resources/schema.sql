-- Drop tables if they exist
DROP TABLE IF EXISTS compatibility_matrix;
DROP TABLE IF EXISTS compatibility_label;
DROP TABLE IF EXISTS calendar_day;
DROP TABLE IF EXISTS user_profile;

-- UserProfile table
CREATE TABLE user_profile (
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    lifepath_number INT,
    PRIMARY KEY (user_id)
);

-- CalendarDay table
CREATE TABLE calendar_day (
    calendar_day_id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT,
    date DATE NOT NULL,
    calendar_day_number INT,
    PRIMARY KEY (calendar_day_id),
    FOREIGN KEY (user_id) REFERENCES user_profile(user_id) ON DELETE CASCADE
);

-- CompatibilityLabel table
CREATE TABLE compatibility_label (
    label_id BIGINT NOT NULL AUTO_INCREMENT,
    match_type VARCHAR(50) NOT NULL,
    title VARCHAR(128),
    description TEXT,
    PRIMARY KEY (label_id)
);

-- CompatibilityMatrix table (many-to-many join with meta)
CREATE TABLE compatibility_matrix (
    matrix_id BIGINT NOT NULL AUTO_INCREMENT,
    
    lifepath_number INT NOT NULL,
    calendar_day_number INT NOT NULL,
    label_id BIGINT NOT NULL,
    
    PRIMARY KEY (matrix_id),
    
    UNIQUE (lifepath_number, calendar_day_number),

    FOREIGN KEY (label_id) REFERENCES compatibility_label(label_id)

);