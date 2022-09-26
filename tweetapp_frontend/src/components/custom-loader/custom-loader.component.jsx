import React from 'react';
import './custom-loader.styles.css';
import Loader from 'react-loader-spinner';
import Modal from 'react-modal';

Modal.setAppElement('#root');

export default function CustomLoader(props) {
  return (
    <Modal
      isOpen={props.global.loaderEnabled}
      style={{
        overlay: {
          backgroundColor: 'rgba(0, 0, 0, 0.85)',
          zIndex: 500000,
        },
        content: {
          backgroundColor: 'rgba(255, 255, 255, 0.0001)',
          borderWidth: 0,
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center',
        },
      }}>
      <div align="center">
        <Loader
          type="Oval"
          color="#0578BE"
          height={40}
          width={40}
          visible={true}
        />
        <p
          style={{
            color: 'white',
            marginTop: '20px',
            fontFamily: 'OpenSans-Regular',
            fontSize: '20px',
          }}
          align={'center'}>
          {props.global.loaderMessage }
        </p>
      </div>
    </Modal>
  );
}
