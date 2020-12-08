--TABLE_NAME =job_type
INSERT INTO career_day.job_type (id, name) VALUES (101, 'SOFTWARE DEVELOPER');
INSERT INTO career_day.job_type (id, name) VALUES (102, 'HARDWARE ENGINEERING');
INSERT INTO career_day.job_type (id, name) VALUES (103, 'NETWORK ENGINEERING');

--TABLE_NAME =job_applicant
INSERT INTO career_day.job_applicant (id, education_level, email, first_name, last_name, phone, years_of_experience) VALUES (1, 'POST_GRADUATE', 'paul@gmail.com', 'Paul', 'Teko', '0711111111', 0);
INSERT INTO career_day.job_applicant (id, education_level, email, first_name, last_name, phone, years_of_experience) VALUES (4, 'POST_GRADUATE', 'abc@gmail.com', 'Candy', 'Abebe', '0711111111', 0);
INSERT INTO career_day.job_applicant (id, education_level, email, first_name, last_name, phone, years_of_experience) VALUES (7, 'GRADUATE', 'xyzy@gmail.com', 'Terry', 'Ann', '0791111', 1);commit ;

--TABLE_NAME =job
INSERT INTO career_day.job (id, description, education_leve, interview_date, interview_end_time, interview_start_time, name, status, years_of_experience, job_type_id) VALUES (1, 'Software Development', 'GRADUATE', '2020-12-23', '2020-12-23', '2020-12-23', 'Software Development', 'ACTIVE', 3, 101);
INSERT INTO career_day.job (id, description, education_leve, interview_date, interview_end_time, interview_start_time, name, status, years_of_experience, job_type_id) VALUES (2, 'Hardware Engineering', 'POST_GRADUATE', '2020-12-24', '2020-12-24', '2020-12-24', 'Hardware Engineering', 'ACTIVE', 4, 102);
INSERT INTO career_day.job (id, description, education_leve, interview_date, interview_end_time, interview_start_time, name, status, years_of_experience, job_type_id) VALUES (3, 'Network Engineering', 'HIGHER_DIPLOMA', '2020-12-25', '2020-12-25', '2020-12-25', 'Network Engineering', 'ACTIVE', 2, 103);

--TABLE_NAME =applications

INSERT INTO career_day.applications (id, date_applied, job_id,job_applicant_id)values (1,'2020-12-23',1,1);
INSERT INTO career_day.applications (id, date_applied, job_id,job_applicant_id)values ( 2,'2020-12-23',2,4);
INSERT INTO career_day.applications (id, date_applied, job_id,job_applicant_id)values (3,'2020-12-23',3,7);
--TABLE_NAME =Users


INSERT INTO career_day.user (id, status, attempts, password, username) VALUES (3, 1, 0, '123TRS', 'abe@gmail.com');
INSERT INTO career_day.user (id, status, attempts, password, username) VALUES (8, 1, 0, '123ABC', 'XYZ@gmail.com');
INSERT INTO career_day.user (id, status, attempts, password, username) VALUES (10, 1, 0, '123XYZ', 'KLJ@gmail.com');

