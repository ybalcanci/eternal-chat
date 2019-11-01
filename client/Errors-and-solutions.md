1)
I tried an assignment in render function of App component with
const {messages, isLoading} = this.state;
but I got an error saying:
```
Property 'messages' does not exist on type 'Readonly<{}>'
```
I solved it by replacing
```
class App extends React.Component
```
with
```
class App extends React.Component<{}, { messages: Array<any>, isLoading: boolean }>
```
https://stackoverflow.com/questions/34960178/typescript-react-componentdidmount-not-getting-called
