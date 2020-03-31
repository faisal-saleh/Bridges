import React from 'react';
import {SafeAreaView, Image} from 'react-native';
import PanoramicView from './PanoramicView';

const image1 = require('./one.jpeg');
const image2 = require('./two.jpeg');

export const PanoramaExample = () => {
  return (
    <SafeAreaView>
      <Image
        style={{width: '100%', height: 300}}
        resizeMode="cover"
        source={image2}
      />
      <PanoramicView
        style={{width: '100%', height: 300}}
        alpha={1}
        rotateInertia={2}
      />
    </SafeAreaView>
  );
};
