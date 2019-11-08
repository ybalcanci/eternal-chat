import React from 'react';
import './App.css';

class App extends React.Component<{}, { messages: Array<any>, isLoading: boolean, text: string }> {
    constructor(props: any) {
        super(props);
        this.state = {
            messages: [],
            isLoading: false,
            text: ""
        }
    }

    componentDidMount(): void {
        this.getMessages()
    }

    getMessages = async () => {
        this.setState({isLoading: true});
        fetch('http://localhost:8080', {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(data => this.setState({messages: data, isLoading: false}));
    }

    sendMessage = async () => {
        await fetch('http://localhost:8080', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({text: "sa", sender: {id: 1, username: 'ybal'}})
        });
        this.clearTextArea()
    }

    clearTextArea = () => {
        this.setState({
            text: ""
        })
    }

    render(): React.ReactElement<any, string | React.JSXElementConstructor<any>> | string | number | {} | React.ReactNodeArray | React.ReactPortal | boolean | null | undefined {
        const {messages, isLoading} = this.state;
        if (isLoading) {
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
