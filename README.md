# JAICF+Rasa project template

Here is a ready to use [JAICF](https://framework.just-ai.com) bot template _written in Kotlin_ that utilises a [Rasa](https://rasa.com) NLU service and can be deployed to Heroku cloud with a single click.
You can use this project as a templated JAICF-based project with Rasa NLU engine.

## How to use

You can deploy this template right on [Heroku](https://heroku.com) cloud and then modify and debug it locally on your PC.

### 1. Deploy Rasa server

Once this project utilises a Rasa NLU, you have firstly to deploy a Rasa server to the Heroku cloud.
Here is a [ready to use template](https://github.com/just-ai/rasa-heroku-template), that can be deployed to Heroku with a single click.

_Once deployed, copy the server's URL for the next step._

### 2. Create a Telegram bot

This project is a [Telegram](https://telegram.org/) chatbot, thus you have to [create a Telegram bot](https://core.telegram.org/bots#3-how-do-i-create-a-bot) and obtain it's token.

_JAICF is a [multi-platform framework](https://github.com/just-ai/jaicf-kotlin/wiki/Channels#multi-channel-support), thus this project can be connected to any channel, not only a Telegram._

### 3. Deploy to Heroku

Once you've deployed Rasa NLU and created Telegram bot, you can deploy this project to Heroku cloud.
Just click on the button below.

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

Now you can open chat with your Telegram bot via preferred Telegram client.

![](https://i.imgur.com/dwO6LYy.gif)

## How to upload code changes to Heroku

Please make the next steps to upload your changes on Heroku.

Install [git](https://git-scm.com/downloads) and [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli#download-and-install).
Run a terminal (or console) on your machine and type

```
heroku login
heroku git:clone -a <your Heroku application name>
cd <your Heroku application name>
git remote add origin https://github.com/just-ai/jaicf-rasa-template
git pull origin master
```

_You have to do these steps only once._

Once you are ready to upload your changes to Heroku, just type

```
git add .
git commit -am "some comments"
git push
```

Heroku will build and deploy your changes automatically.

## How to run locally

Import this project in [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) and run `Telegram.kt` file to test your changes in Telegram.
Make sure you've provided your Telegram token in `TELEGRAM_TOKEN` environment variable.

You have also to run your Rasa NLU server locally.
Just use `rasa train` and `rasa run --enable-api` commands in your terminal.

_You can also use [Docker](https://www.docker.com/). Just make changes in NLU model and then `docker build -t rasa .` and `docker run rasa` commands._

## How to make changes in NLU model

You can make changes of NLU model independently from the changes of this code.
Please refer to the [Rasa template](https://github.com/just-ai/rasa-heroku-template) to learn how you can upload your NLU model changes.
