import React from 'react';
import {SafeAreaView, TouchableHighlight, Text} from 'react-native';
import SampleBridge from './BridgeModule';

export const BridgeExample = () => {
  return (
    <SafeAreaView
      style={{flex: 1, justifyContent: 'space-between', alignItems: 'center'}}>
      <TouchableHighlight
        style={{borderColor: 'red', borderWidth: 1, padding: 4}}
        onPress={() =>
          SampleBridge.showToast('Hello there', SampleBridge.long)
        }>
        <Text>Show Toast</Text>
      </TouchableHighlight>

      <TouchableHighlight
        style={{borderColor: 'red', borderWidth: 1, padding: 4}}
        onPress={() =>
          SampleBridge.callbackExample(
            1,
            msg => console.warn(msg),
            error => console.warn(error),
          )
        }>
        <Text>Callback</Text>
      </TouchableHighlight>

      <TouchableHighlight
        style={{borderColor: 'red', borderWidth: 1, padding: 4}}
        onPress={async () => {
          try {
            const message = await SampleBridge.promiseExample(0);
            console.warn(message);
          } catch (error) {
            console.warn(error);
          }
        }}>
        <Text>Promise</Text>
      </TouchableHighlight>
    </SafeAreaView>
  );
};
