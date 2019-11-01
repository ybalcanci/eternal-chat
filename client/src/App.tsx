import React from 'react';
import logo from './logo.svg';
import './App.css';

class App extends React.Component<{}, { messages: Array<any>, isLoading: boolean }>{
  constructor(props: any){
    super(props);
    this.state = {
      messages: [],
      isLoading: false
    }
  }
  componentDidMount(): void {
    this.setState({ isLoading: true });
    fetch('http://localhost:8080/messages')
        .then(response => response.json())
        .then(data => this.setState({ messages: data, isLoading: false }));
  }

  render(): React.ReactElement<any, string | React.JSXElementConstructor<any>> | string | number | {} | React.ReactNodeArray | React.ReactPortal | boolean | null | undefined {
    const {messages, isLoading} = this.state;
    if(isLoading){
      return <p>Loading...</p>;
    }
    return (
        <div className="App">
          {messages.map((message: any) =>
              <div key={message.id}>
                {message.text}
              </div>
          )}
        </div>
    );
  }
}

export default App;
