# Instant Messaging Web Application Development Lifecycle

This file highlights my approach to completing this project, due to time limitation (this being a fun/side project). My goal
is to document and clearly define each component needed to successfuly complete the app, by creating a list of features and
implementing each one till completion. Each feature is mean't to be completed in short sprints (a sprint in my case is
2-6 hours), this allows for easier testing and incremental development.

## Development Steps:
	- Clearly define feature requirements
	- Create feature branch, format: <app abbreviated name>-<3 digit code>_<description line separated by ‘-‘>
	- Develop feature using TDD (test driven dev guidelines)
		- for each feature functionality/component
			- write a failed test case
			- write enough logic to pass the failed test case
			- refactor if needed

## Features:
### imapp-200_add-sql-db-tables
	- add sql files to create auth db user used by hibernate
	- add sql files to create DB “chat_app”
	- add sql files to create DB user table and roles table
### imapp-201_create-login-page
	- create html login page
	- add authentication requirements
	- add form validation
### imapp-202_create-registration-page
	- create html registration page
	- add authentication requirements
	- add form validation
### imapp-203_user-settings-display-user-info
	- on main page post login, user settings should display user info from DB
