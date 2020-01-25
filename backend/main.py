import json
from flask import Flask

app = Flask(__name__)

@app.route("/")
def hello():
    return "Hello, ada!"

@app.route("/home")
def home():
	with open('json/home.json') as json_file:
		data = json.load(json_file)

		return data


