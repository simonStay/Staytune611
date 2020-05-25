import React, { Component } from 'react';
import { GiftedChat } from 'react-native-gifted-chat';
import { Dialogflow_V2 } from 'react-native-dialogflow';
import { dialogflowConfig } from './env'; 

const BOT_USER = {
    _id: 2,
    name: 'Artificial Advisor',
    avatar: 'https://i.imgur.com/7k12EPD.png'
  };

export default class chat extends Component {

   static navigationOptions = {
      title : 'Home',
    }

    state = {
        messages: [
            {
                _id: 1,
                text: 'Hello!',
                createdAt: new Date(),
                user: BOT_USER,
            }
            
        ],
    }
    componentDidMount() {
        Dialogflow_V2.setConfiguration(
            dialogflowConfig.client_email,
            dialogflowConfig.private_key,
            Dialogflow_V2.LANG_ENGLISH_US,
            dialogflowConfig.project_id
        );
    }
 
    onSend(messages = []) {
        this.setState(previousState => ({
        messages: GiftedChat.append(previousState.messages, messages),
        }));
        let message = messages[0].text;

        Dialogflow_V2.requestQuery(
            message,
            result => this.DialogFlowAgentResponse(result),
            error => console.log(error)
        );
    }

    DialogFlowAgentResponse(result) {
        let text = result.queryResult.fulfillmentMessages[0].text.text[0];
        this.reply(text); 
    } 

reply(text) {
    let msg = {
        _id: this.state.messages.length + 1,
        text,
        createdAt: new Date(),
        user: BOT_USER
    };

    this.setState(currentState => ({
        messages: GiftedChat.append(currentState.messages, [msg])
    }));}

 render() {
    return (
    <GiftedChat
        messages={this.state.messages}
        onSend={messages => this.onSend(messages)}
        user={{
            _id: 1,
        }}
    />
    );
}
}


