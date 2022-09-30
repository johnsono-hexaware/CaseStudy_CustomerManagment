const Node = () => {
    let childnodes = null;

    // the Node component calls itself if there are children
    if(this.props.children) {      
      childnodes = this.props.children.map(function(childnode) {
       return (
         <Node node={childnode} children={childnode.dependents} />
       );
     });
    }

    // return our list element
    // display children if there are any
    return (
      <li key={this.props.node.customerId}>      
        <p>{this.props.node.name}</p>        
        { childnodes ?
          <ul>{childnodes}</ul>
        : null }
      </li>
    );
  }

export default Node;