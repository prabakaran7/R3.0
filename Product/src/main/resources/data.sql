-- Test data for login controller
insert into address (id, building_no, city, country, district, door_no, pin_code, state, street_line1, street_line2, taluk) values ('1', '55', 'Chennai', 'India', 'Thiruvallur', '96', '600103', 'TamilNadu', 'Perumal Koil Street', 'Periyamullaivoyal', 'Ponneri');
insert into role (id, description, role) values ('1', 'Administrator', 'admin');
insert into user_data (id, first_name, last_name, middle_name, password, userid, address_id, role_id) values('1', 'Prabakaran', 'Loganathan', NULL, 'praba', 'praba', '1', '1');
